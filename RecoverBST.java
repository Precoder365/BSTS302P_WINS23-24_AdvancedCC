import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Main {
    TreeNode prev;
    TreeNode first;
    TreeNode middle;
    TreeNode last;

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = null;
        inorder(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
    
    public TreeNode stringToTreeNode(String input) {
        input = input.trim();
        if (input.isEmpty() || input.equals("[]")) {
            return null;
        }

        String[] values = input.substring(1, input.length() - 1).split(",");
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) {
            if (!values[i].equals("null")) {
                nodes[i] = new TreeNode(Integer.parseInt(values[i].trim()));
            }
        }

        TreeNode root = nodes[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode parent = queue.poll();
            if (parent != null) {
                parent.left = nodes[i];
                if (i + 1 < nodes.length) {
                    parent.right = nodes[i + 1];
                }
                queue.offer(parent.left);
                queue.offer(parent.right);
            }
        }

        return root;
    }
    
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        String input = "[3,1,4,null,null,2]";
        Main solution = new Main();
        TreeNode root = solution.stringToTreeNode(input);

        System.out.println("Inorder traversal of the binary tree before recovery:");
        solution.inorderTraversal(root);

        solution.recoverTree(root);

        System.out.println("\nInorder traversal of the binary tree after recovery:");
        solution.inorderTraversal(root);
    }
}
