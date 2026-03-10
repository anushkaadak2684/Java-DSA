import java.util.*;
public class ArraytoBST {
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

    public static Node createBST(int nodes[], int start, int end){
        if(start > end)
            return null;

        int mid = (start + end)/2;
        Node root = new Node(nodes[mid]);
        root.left = createBST(nodes, start, mid-1);
        root.right = createBST(nodes, mid+1, end);
        return root;
    }

    public static void preorder(Node root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes[] = new int[7];
        System.out.print("Enter a sorted array of nodes: ");
        for(int i=0; i<7; i++)
            nodes[i] = in.nextInt();
        Node root = createBST(nodes, 0, nodes.length-1);
        System.out.print("Balanced BST: ");
        preorder(root);
        in.close();
    }
}