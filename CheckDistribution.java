import java.util.*;

public class Main{
    public static boolean checkPossible(int[] arr, int n, int k){
        Map<Integer,Integer> hmap=new HashMap<>();
        for(int i=0;i<n;i++){
            if(hmap.containsKey(arr[i])){
                hmap.put(arr[i],hmap.get(arr[i])+1);
            }
            else{
                hmap.put(arr[i],1);
            }
        }
        
        System.out.println(hmap);
        
        for(Map.Entry<Integer, Integer> entry: hmap.entrySet()){
            if (entry.getValue()>2*k){
                return false;
            }
        }
        
        return true;
        
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int k=sc.nextInt();
        
        if (checkPossible(arr,n,k)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
