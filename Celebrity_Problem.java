import java.util.*;

public class Main{
    public static int celebrity(int[][] arr, int n){
        List<Integer> ls=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    cnt++;
                }
            }
            if(cnt==n){
                ls.add(i);
            }
        }
        
        for(int i=0;i<ls.size();i++){
            int ele=ls.get(i);
            boolean flag=true;
            for(int j=0;j<n;j++){
                if(ele!=j && arr[j][ele]==0){
                    flag=false;
                }
            }
            if(flag){
                return ele;
            }
        }
        
        return -1;
    }
    
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int arr[][]=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        System.out.println(celebrity(arr,n));
    }
}
