import java.util.*;

public class Main{
    static class CustomPair {
        int val;
        int ind;
 
        public CustomPair(int val, int ind)
        {
            this.val = val;
            this.ind = ind;
        }
    }
    
    public static List<Integer> maxSliding(int[] arr, int n, int k){
        PriorityQueue<CustomPair> pq=new PriorityQueue<>((a, b) -> b.val - a.val);
        List<Integer> ans=new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            pq.offer(new CustomPair(arr[i], i));
        }
        
        ans.add(pq.peek().val);
        
        for (int i=k; i<n; i++) {
            pq.offer(new CustomPair(arr[i], i));
            
            while (pq.peek().ind <= i-k) {
                pq.poll();
            }
            
            ans.add(pq.peek().val);
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
        
        List<Integer> ans=maxSliding(arr,n,k);
        
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i)+" ");
        }
    }
}
