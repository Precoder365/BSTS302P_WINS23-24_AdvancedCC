import java.util.*;

public class Main{
    public static boolean checkIfSubsetExists(int[] arr,int n,int k){
        if (k==0) return true;
        if (n==0) return false;
        if (arr[n-1]>k){
            return checkIfSubsetExists(arr,n-1,k);
        }
        else{
            return checkIfSubsetExists(arr,n-1,k) || checkIfSubsetExists(arr,n-1,k-arr[n-1]);
        }
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int k=sc.nextInt();
        
        if(checkIfSubsetExists(arr,n,k)) System.out.println("Exists");
        else System.out.println("DNE");
    }
}
