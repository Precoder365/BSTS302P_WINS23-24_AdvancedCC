import java.util.*;

public class Main {
    public static void BFS_helper(int[][] matrix, int start, int v, boolean[] visited) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        pendingVertices.offer(start);
        visited[start] = true;

        while (!pendingVertices.isEmpty()) {
            int front = pendingVertices.poll();
            System.out.print(front + " ");
            for (int i = 0; i < v; i++) {
                if (matrix[front][i] == 1 && !visited[i]) {
                    pendingVertices.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void BFS_print(int[][] matrix, int v) {
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                BFS_helper(matrix, i, v, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][] matrix = new int[v][v];

        for (int j = 0; j < e; j++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            matrix[sv][ev] = 1;
            matrix[ev][sv] = 1;
        }

        BFS_print(matrix, v);
    }
}
