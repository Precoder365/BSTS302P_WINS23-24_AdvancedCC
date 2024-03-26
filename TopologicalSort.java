import java.util.*;

public class Main{
    public static void topologicalSortBFS(ArrayList<ArrayList<Integer>> lst,int v){
        int[] indegree=new int[v];
        for(int i=0;i<v;i++){
            for(int j=0;j<lst.get(i).size();j++){
                indegree[lst.get(i).get(j)]+=1;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int node=q.poll();
            System.out.print(node+" ");
            for(int j=0;j<lst.get(node).size();j++){
                indegree[lst.get(node).get(j)]-=1;
                if(indegree[lst.get(node).get(j)]==0){
                    q.offer(lst.get(node).get(j));
                }
            }
        }
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int v=sc.nextInt();
        int e=sc.nextInt();
        
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            lst.add(new ArrayList<>());
        }
        
        for(int i=0;i<e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            
            lst.get(s).add(d);
        }
        
        topologicalSortBFS(lst,v);
    }
}
