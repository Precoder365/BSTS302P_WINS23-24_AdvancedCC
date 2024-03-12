import java.util.*;

public class Main{
    public static int[] maxSliding(int[] arr,int n,int k){
        int ans[]=new int[n-k+1];
        int ind=0;
        
        for(int i=0;i<=n-k;i++){
            int maxi=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(arr[j]>maxi){
                    maxi=arr[j];
                }
            }
            ans[ind]=maxi;
            ind++;
        }
        
        return ans;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int k=sc.nextInt();
        
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int ans[]=maxSliding(arr,n,k);
        
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]+" ");
        }
    }
}
