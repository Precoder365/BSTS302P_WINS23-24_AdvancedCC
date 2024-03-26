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

class Pair{
    BinaryTreeNode<Integer> node;
    int xVal;
    
    public Pair(BinaryTreeNode<Integer> node, int xVal){
        this.node=node;
        this.xVal=xVal;
    }
}

public class Main {
    
    // VIEWS
    
    public static boolean isLeaf(BinaryTreeNode<Integer> node){
        return node.left==null && node.right==null;
    }
    
    public static void leftBoundary(BinaryTreeNode<Integer> root, ArrayList<Integer> lst){
        BinaryTreeNode<Integer> curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr)) lst.add(curr.data);
            if(curr.left!=null) curr=curr.left;
            else curr=curr.right;
        }
    }
    
    // Preorder
    public static void leaves(BinaryTreeNode<Integer> root, ArrayList<Integer> lst){
        if(root==null) return;
        if(isLeaf(root)) lst.add(root.data);
        leaves(root.left,lst);
        leaves(root.right,lst);
    }
    
    public static void rightBoundary(BinaryTreeNode<Integer> root, ArrayList<Integer> lst){
        BinaryTreeNode<Integer> curr=root.right;
        
        Stack<Integer> st=new Stack<>();
        while(curr!=null){
            if(!isLeaf(curr)) st.push(curr.data);
            if(curr.right!=null) curr=curr.right;
            else curr=curr.left;
        }
        
        while(!st.isEmpty()){
            lst.add(st.pop());
        }
    }
    
    public static void Boundary(BinaryTreeNode<Integer> root){
        if(root==null) return;
        
        ArrayList<Integer> lst=new ArrayList<>();
        lst.add(root.data);
        
        leftBoundary(root,lst);
        leaves(root,lst);
        rightBoundary(root,lst);
        
        for(int i=0;i<lst.size();i++){
            System.out.print(lst.get(i)+" ");
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
        Boundary(root);
    }
    // 1 2 3 4 10 9 10 -1 5 -1 -1 -1 -1 -1 -1 -1 6 -1 -1
}
