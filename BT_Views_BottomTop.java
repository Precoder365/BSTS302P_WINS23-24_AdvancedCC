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
    public static void Top(BinaryTreeNode<Integer> root){
        if(root==null) return;
        
        // The map is sorted according to the natural ordering of its keys
        Map<Integer,Integer> map=new TreeMap<>();
        
        Queue<Pair> pendingNodes=new LinkedList<>();
        pendingNodes.offer(new Pair(root,0));
        
        while(!pendingNodes.isEmpty()){
            Pair front=pendingNodes.poll();
            BinaryTreeNode<Integer> node=front.node;
            int xVal=front.xVal;
            
            if(map.get(xVal)==null){
                map.put(xVal,node.data);
            }
            
            if(node.left!=null){
                pendingNodes.offer(new Pair(node.left,xVal-1));
            }
            if(node.right!=null){
                pendingNodes.offer(new Pair(node.right,xVal+1));
            }
        }
        
        for (int key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }
    }
    
    public static void Bottom(BinaryTreeNode<Integer> root){
        if(root==null) return;
        
        // The map is sorted according to the natural ordering of its keys
        Map<Integer,Integer> map=new TreeMap<>();
        
        Queue<Pair> pendingNodes=new LinkedList<>();
        pendingNodes.offer(new Pair(root,0));
        
        while(!pendingNodes.isEmpty()){
            Pair front=pendingNodes.poll();
            BinaryTreeNode<Integer> node=front.node;
            int xVal=front.xVal;
            
            map.put(xVal,node.data);
            
            if(node.left!=null){
                pendingNodes.offer(new Pair(node.left,xVal-1));
            }
            if(node.right!=null){
                pendingNodes.offer(new Pair(node.right,xVal+1));
            }
        }
        
        for (int key : map.keySet()) {
            System.out.print(map.get(key) + " ");
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
        System.out.println("Top view");
        Top(root);
        System.out.println("\nBottom view");
        Bottom(root);
    }
    // 1 2 3 4 10 9 10 -1 5 -1 -1 -1 -1 -1 -1 -1 6 -1 -1
}
