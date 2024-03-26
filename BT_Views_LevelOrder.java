import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {
    
    // VIEWS
    
    public static void LevelOrder(BinaryTreeNode<Integer> root){
        if(root==null) return;
        
        Queue<BinaryTreeNode<Integer>> pendingNodes=new LinkedList<>();
        pendingNodes.offer(root);
        pendingNodes.offer(null);
        
        while(pendingNodes.size()==1 || !pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front=pendingNodes.poll();
            if(front==null){
                System.out.println();
                // Dont offer without checking if queue is empty
                if(!pendingNodes.isEmpty()){
                    pendingNodes.offer(null);
                }
                continue;
            }
            System.out.print(front.data+" ");
            
            if(front.left!=null){
                pendingNodes.offer(front.left);
            }
            if(front.right!=null){
                pendingNodes.offer(front.right);
            }
        }
    }
    
    public static BinaryTreeNode<Integer> inputTreeLevelWise() {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter root data: ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNodes.poll();

            // System.out.print("Enter left child of " + front.data + ": ");
            int leftData = sc.nextInt();
            if (leftData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftData);
                front.left = leftChild;
                pendingNodes.offer(leftChild);
            }

            // System.out.print("Enter right child of " + front.data + ": ");
            int rightData = sc.nextInt();
            if (rightData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightData);
                front.right = rightChild;
                pendingNodes.offer(rightChild);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = inputTreeLevelWise();
        LevelOrder(root);
    }
}
