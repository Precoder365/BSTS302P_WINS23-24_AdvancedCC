import java.util.*;

public class Main{
    public static int[] stockSpan(int[] arr, int n){
        int[] ans=new int[n];
        ans[0]=1;
        
        for(int i=1;i<n;i++){
            ans[i]=1;
            for(int j=i-1;j>=0 && arr[j]<arr[i];j--){
                ans[i]+=1;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int ans[]=stockSpan(arr,n);
        
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
