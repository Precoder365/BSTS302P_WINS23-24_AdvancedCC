import java.util.*;

public class Main{
    public static int lbs(int[] arr,int n){
        if(arr==null || n==0) return 0;
        
        int[] lis=new int[n];
        int[] lds=new int[n];
        
        for(int i=0;i<n;i++){
            lis[i]=1;
            lds[i]=1;
        }

        // i[1,n-1] and j[0,i-1]
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;
                }
            }
        }

        // i[n-1,0] and j[n-1,i-1]
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j] && lds[i]<lds[j]+1){
                    lds[i]=lds[j]+1;
                }
            }
        }
        
        int maxi=lis[0]+lds[0]-1;
        for(int i=0;i<n;i++){
            if(lis[i]+lds[i]-1>maxi){
                maxi=lis[i]+lds[i]-1;
            }
        }
        
        return maxi;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        System.out.println(lbs(arr,n));
    }
}
