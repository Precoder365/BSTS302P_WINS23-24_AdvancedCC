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

class Tuple {
    BinaryTreeNode<Integer> node;
    int row;
    int col;
    public Tuple(BinaryTreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}

public class Main {
    
    // VIEWS
    
    public static List<List<Integer>> Vertical(BinaryTreeNode<Integer> root) {
        TreeMap <Integer,TreeMap<Integer, PriorityQueue <Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList < Tuple > ();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            BinaryTreeNode<Integer> node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;


            if (!map.containsKey(x)) {
                map.put(x, new TreeMap < > ());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue < > ());
            }
            map.get(x).get(y).offer(node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        
        List <List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue <Integer>> ys: map.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue <Integer> nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }
            list.add(column);
        }
        return list;
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
        List<List<Integer>> list = Vertical(root);
        
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    // 1 2 3 4 10 9 10 -1 5 -1 -1 -1 -1 -1 -1 -1 6 -1 -1
}
