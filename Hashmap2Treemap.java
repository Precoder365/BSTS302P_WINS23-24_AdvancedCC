import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Three");
        hashMap.put(1, "One");
        hashMap.put(2, "Two");

        // Convert HashMap to TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>(hashMap);
        
        System.out.println("TreeMap: " + treeMap);
    }
}

// ------------------------ For custom comparator ------------------------------

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Three");
        hashMap.put(1, "One");
        hashMap.put(2, "Two");

        //Descending order
        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1<o2) {
                    return 1; 
                } else if (o1>o2) {
                    return -1;
                }
                return 0;
            }
        };

        TreeMap<Integer, String> treeMap = new TreeMap<>(customComparator);
        treeMap.putAll(hashMap); 

        System.out.println("TreeMap with custom comparator: " + treeMap);
    }
}
