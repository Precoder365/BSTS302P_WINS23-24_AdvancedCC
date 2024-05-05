import java.util.*;

public class Main{
    public static int lis(int[] arr, int n){
        int[] L=new int[n];
    
        L[0]=1;
        for(int i=1;i<n;i++){
            L[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && L[i]<L[j]+1){
                    L[i]=L[j]+1;
                }
            }
        }
        
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(L[i]>maxi){
                maxi=L[i];
            }
        }
        
        return maxi;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        System.out.println(lis(arr,n));
    }
}
