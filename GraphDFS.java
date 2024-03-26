import java.util.Scanner;

public class Main {
    public static void DFS_helper(int[][] matrix, int start, int v, boolean[] visited) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int i = 0; i < v; i++) {
            if (matrix[start][i] == 1 && !visited[i]) {
                DFS_helper(matrix, i, v, visited);
            }
        }
    }

    public static void DFS_print(int[][] matrix, int v) {
        boolean[] visited = new boolean[v]; // default false

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                DFS_helper(matrix, i, v, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][] matrix = new int[v][v]; // default 0s

        for (int j = 0; j < e; j++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            matrix[sv][ev] = 1;
            matrix[ev][sv] = 1;
        }

        DFS_print(matrix, v);
    }
}
