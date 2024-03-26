import java.util.*;

public class Main{
    public static void dfs(ArrayList<ArrayList<Integer>> lst,boolean[] visited, Stack<Integer> ans, int node, int v){
        visited[node]=true;
        
        for(int i=0;i<lst.get(node).size();i++){
            int adjacentNode = lst.get(node).get(i);
            if (!visited[adjacentNode]) {
                dfs(lst, visited, ans, adjacentNode, v); // Pass adjacentNode 
            }
        }
        
        ans.push(node);
    }
    
    public static void topologicalSort(ArrayList<ArrayList<Integer>> lst,int v){
        boolean[] visited=new boolean[v];
        
        Stack<Integer> ans=new Stack<>();
        
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(lst,visited,ans,i,v);
            }
        }
        
        while(!ans.isEmpty()){
            System.out.print(ans.pop()+" ");
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
        
        topologicalSort(lst,v);
    }
}
