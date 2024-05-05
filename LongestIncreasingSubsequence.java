import java.util.*;

public class Main{
    public static int lis(int[] arr, int n){
        if(arr==null || n==0) return -0;
        
        List<List<Integer>> lis=new ArrayList<>();
        for(int i=0;i<n;i++){
            lis.add(new ArrayList<>());
        }
        
        lis.get(0).add(arr[0]);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && lis.get(i).size()<lis.get(j).size()){
                    lis.set(i,new ArrayList<>(lis.get(j)));
                }
            }
            lis.get(i).add(arr[i]);
        }
        
        int peak=0;
        for(int i=1;i<n;i++){
            if(lis.get(i).size()>lis.get(peak).size()){
                peak=i;
            }
        }
        
        for(int ele: lis.get(peak)){
            System.out.print(ele+" ");
        }
        
        return lis.get(peak).size();
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        System.out.println("Size="+lis(arr,n));
    }
}
