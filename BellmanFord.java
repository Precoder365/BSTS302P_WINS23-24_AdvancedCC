import java.util.*;

public class Main {
    public static void bellmanFord(int[][] graph, int V, int E) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; 
        
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = graph[j][0];
                int v = graph[j][1];
                int weight = graph[j][2];   
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative weight cycles
        for (int i = 0; i < E; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            int weight = graph[i][2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print the distances from the source vertex
        for (int i = 0; i < V; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] graph = new int[E][3]; 

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            graph[i][0] = u;
            graph[i][1] = v;
            graph[i][2] = weight;
        }

        bellmanFord(graph, V, E);
    }
}
