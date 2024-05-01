import java.util.*;

public class Main {
    static boolean checkCount(int[] arr, int n, int k) {
        int count;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i])
                    count++;
                if (count > 2 * k)
                    return false;
            }
        }

        return true;
    }
    
    static boolean checkCountHash(int arr[], int n, int k){
    	HashMap <Integer, Integer> hash = new HashMap<>();
    		for (int i = 0; i < n; i++){
    			if (!hash.containsKey(arr[i]))
    				hash.put(arr[i], 0);
    			hash.put(arr[i], hash.get(arr[i]) + 1);
    		}
    		
    		for (Map.Entry x : hash.entrySet()){
            	if ((int)x.getValue() > 2 * k)
            		return false;
            }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 1 };
        int n = arr.length;
        int k = 2;
        if (checkCount(arr, n, k)){
            System.out.println("Yes it is possible to distribute");
        }
        if (checkCountHash(arr, n, k)){
            System.out.println("Yes it is possible to distribute (hash method)");
        }
        else{
            System.out.println("No it is not possible to distribute");
        }
    }
}
