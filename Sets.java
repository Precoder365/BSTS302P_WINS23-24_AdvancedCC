import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        // --------------- HASHSET ------------------
        
        Set<String> hashSet = new HashSet<>();

        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");

        System.out.println("HashSet elements: " + hashSet);
        
        // ------------- LINKEDHASHSET -------------
        
        Set<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Orange");

        System.out.println("LinkedHashSet elements: " + linkedHashSet);
        
        // --------- TREESET ----------------------
        
        Set<String> treeSet = new TreeSet<>();

        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Orange");

        System.out.println("TreeSet elements: " + treeSet);
        
        // Methods
        
        // set.size()
        // set.contains()
        // set.isEmpty()
        // set.add()
        // set.remove()
        // set.clear
        
        for(String element: treeSet){
            System.out.println(element);
        }
        
        // Union
        // Set<String> unionSet = new HashSet<>(set1);
        // unionSet.addAll(set2);

        // Intersection
        // Set<String> intersectionSet = new HashSet<>(set1);
        // intersectionSet.retainAll(set2);
        
        // Set difference
        // Set<String> differenceSet = new HashSet<>(set1);
        // differenceSet.removeAll(set2);
        
    }
}
