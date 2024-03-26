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
    
    static List<Integer> lst=new ArrayList<>();
    
    public static void Right(BinaryTreeNode<Integer> root,int level){
        if(root==null) return;
        
        if(lst.size()==level){
            lst.add(root.data);
        }
        
        Right(root.right,level+1);
        Right(root.left,level+1);
    }
    
    public static void Left(BinaryTreeNode<Integer> root, int level){
        if(root==null) return;
        
        if(lst.size()==level){
            lst.add(root.data);
        }
        
        Left(root.left,level+1);
        Left(root.right,level+1);
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
        Right(root,0);
        
        System.out.println("Right view");
        for(int i=0;i<lst.size();i++){
            System.out.print(lst.get(i)+" ");
        }
        
        lst.clear();
        
        Left(root,0);
        
        System.out.println("\nLeft view");
        for(int i=0;i<lst.size();i++){
            System.out.print(lst.get(i)+" ");
        }
    }
    // 1 2 3 4 10 9 10 -1 5 -1 -1 -1 -1 -1 -1 -1 6 -1 -1
}
