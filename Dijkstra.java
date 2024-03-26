import java.util.*;

public class Main {
    private static int findMinVertex(int[] dist, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && (minVertex == -1 || dist[i] < dist[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    private static void dijkstra(int[][] matrix, int v) {
        // Boolean arrays are initialized to false by default
        boolean[] visited = new boolean[v];
        
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        for (int i = 0; i < v - 1; i++) {
            int minVertex = findMinVertex(dist, visited);
            visited[minVertex] = true;
            
            for (int j = 0; j < v; j++) {
                if (matrix[minVertex][j] != 0 && !visited[j]) {
                    int newDist = dist[minVertex] + matrix[minVertex][j];
                    if (newDist < dist[j]) {
                        dist[j] = newDist;
                    }
                }
            }
        }

        // Printing shortest distances from source vertex to all other vertices
        for (int i = 0; i < v; i++) {
            System.out.println(i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); 
        int e = sc.nextInt(); 

        int[][] matrix = new int[v][v];
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt(); 
            int d = sc.nextInt(); 
            int w = sc.nextInt(); 
            matrix[s][d] = w;
        }

        dijkstra(matrix, v);
    }
}
