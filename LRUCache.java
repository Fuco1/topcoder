import java.util.*;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int size;

    public LRUCache(int size) {
        super(16, 0.75f, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > size;
    }

    public static void main(String[] args) {
        LRUCache<String, Object> cache = new LRUCache<String, Object>(5);
        Object o = new Object();
        cache.put("0", o);
        cache.put("1", o);
        cache.put("2", o);
        cache.put("3", o);
        cache.put("4", o);
        System.out.println(cache);
        System.out.println(cache.keySet().iterator().next());
        cache.put("2", o);
        System.out.println(cache);
        cache.put("5", o);
        System.out.println(cache);
    }
}
