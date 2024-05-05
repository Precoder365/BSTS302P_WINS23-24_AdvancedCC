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

// ---------------------- Using entrySet() -------------------------------

import java.util.*;

public class Main{
    public static void main(String[] args){
        Map<String,String> hmap=new HashMap<>();
        hmap.put("2","Two");
        hmap.put("3","Three");
        hmap.put("1","One");
        hmap.put("100","Hundred");
        
        System.out.println(hmap);
        
        Map<Integer,String> tmap=new TreeMap<>();
        
        for (Map.Entry<String,String> entry: hmap.entrySet()){
            tmap.put(Integer.parseInt(entry.getKey()), entry.getValue());
        }
        
        System.out.println(tmap);
        
        
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
