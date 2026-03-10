import java.util.*;
public class PrintInRange {
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val)
            root.left = insert(root.left, val);
        else if(root.data < val)
            root.right = insert(root.right, val);
    
            return root;
    }
    public static void printInRange(Node root, int k1, int k2){
        if(root == null)
            return;

        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data > k2)
            printInRange(root.left, k1, k2);
        else
            printInRange(root.right, k1, k2);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for(int i=0; i<nodes.length; i++)
            root = insert(root, nodes[i]);
        System.out.print("Enter k1 and k2: ");
        int k1 = in.nextInt();
        int k2 = in.nextInt();
        System.out.print("Nodes between k1 and k2: ");
        printInRange(root, k1, k2);
        in.close();
    }
}
