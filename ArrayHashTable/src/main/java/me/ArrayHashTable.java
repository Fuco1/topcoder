package me;

import java.util.Arrays;

public class ArrayHashTable<K,V> {

    private Item[] items;
    // any non-null thing
    private int occupied = 0;
    // number of deleted objects
    private int deleted = 0;
    private double loadFactor;

    public ArrayHashTable() {
        this(32, 0.7);
    }

    public ArrayHashTable(int size) {
        this(size, 0.7);
    }

    public ArrayHashTable(int size, double loadFactor) {
        items = new Item[size];
        this.loadFactor = loadFactor;
    }

    public int size() {
        return occupied - deleted;
    }

    public int capacity() {
        return items.length;
    }

    // simple linear probing + 1 for now
    private int probeHashCode(int hash, int counter) {
        return (hash + counter) % capacity();
    }

    @SuppressWarnings("unchecked")
    public boolean add(K key, V value) {
        int hash = key.hashCode() % capacity();
        int counter = 0;
        Item item = items[probeHashCode(hash, counter)];

        while (item != null &&
               item != (DeletedItem.getDeletedItem()) &&
               !item.key.equals(key)) {
            counter++;
            if (counter > capacity()) {
                return false; // table is full
            }
            item = items[probeHashCode(hash, counter)];
        }

        if (item == DeletedItem.getDeletedItem()) {
            deleted--;
        }

        if (item == null) {
            occupied++;
        }

        items[probeHashCode(hash, counter)] = new Item(key, value);

        return true;
    }

    @SuppressWarnings("unchecked")
    public V remove(K key) {
        int hash = key.hashCode() % capacity();
        int counter = 0;
        Item item = items[probeHashCode(hash, counter)];
        while (item != null &&
               !item.key.equals(key)) {
            counter++;
            if (counter > capacity()) {
                return null; // not found
            }
            item = items[probeHashCode(hash, counter)];
        }

        if (item == null) {
            return null;
        }
        else {
            deleted++;
            items[probeHashCode(hash, counter)] = DeletedItem.getDeletedItem();
            return (V)item.value;
        }
    }

    // BONUS: we can move entries to DELETED on lookup
    @SuppressWarnings("unchecked")
    public V lookup(K key) {
        int hash = key.hashCode() % capacity();
        int counter = 0;
        Item item = items[probeHashCode(hash, counter)];
        while (item != null &&
               !item.key.equals(key)) {
            counter++;
            if (counter > capacity()) {
                return null; // not found
            }
            item = items[probeHashCode(hash, counter)];
        }
        return item != null ? (V)item.value : null;
    }

    public String toString() {
        return Arrays.toString(items);
    }
}

class Item {

    public Object key;
    public Object value;

    public Item(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return key + " => " + value;
    }
}

class DeletedItem extends Item {

    private static DeletedItem item = null;

    private DeletedItem() {
        super(new Object(), new Object());
    }

    public static DeletedItem getDeletedItem() {
        if (item == null) {
            item = new DeletedItem();
        }
        return item;
    }
}
