import java.util.*;

public class TreePrinter {

    public static void main(String[] args) {
        List<Relation> input = new ArrayList<Relation>();

        input.add(new Relation("animal", "mammal"));
        input.add(new Relation("animal", "bird"));
        input.add(new Relation("lifeform", "animal"));
        input.add(new Relation("cat", "lion"));
        input.add(new Relation("bar", "baz"));
        input.add(new Relation("mammal", "cat"));
        input.add(new Relation("animal", "fish"));
        input.add(new Relation("foo", "bar"));

        TreePrinter.printTree(input);
    }

    public static void printTree(Iterable<Relation> rs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, String> parents = new LinkedHashMap<String, String>();
        for (Relation r : rs) {
            parents.put(r.child, r.parent);
            List<String> children = map.get(r.parent);
            if (children == null) {
                children = new LinkedList<String>();
                map.put(r.parent, children);
            }
            children.add(0, r.child);
        }

        while (!parents.isEmpty()) {
            String root = parents.keySet().iterator().next();
            while (parents.containsKey(root)) {
                root = parents.get(root);
            }
            Deque<String> s = new ArrayDeque<String>();
            s.add(root);
            while (!s.isEmpty()) {
                String p = s.pop();
                parents.remove(p);
                System.out.println(p);
                List<String> children = map.get(p);
                if (children != null) {
                    for (String ch : children) {
                        s.push(ch);
                    }
                }
            }
        }
    }
}

class Relation {
    String parent;
    String child;
    public Relation(String parent, String child) {
        this.parent = parent;
        this.child = child;
    }
}
