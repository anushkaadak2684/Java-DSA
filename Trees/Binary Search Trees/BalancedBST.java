import java.util.*;
public class BalancedBST {
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
    public static void inorder(ArrayList <Integer> inorder, Node root){
        if(root == null)
            return;
        inorder(inorder, root.left);
        inorder.add(root.data);
        inorder(inorder, root.right);
    }
    public static Node createBST(ArrayList <Integer> inorder, int start, int end){
        if(start > end)
            return null;

        int mid = (start + end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, start, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
    }
    public static Node balancedBST(Node root){
        ArrayList <Integer> inorder = new ArrayList<>();
        inorder(inorder, root);
        root = createBST(inorder, 0, inorder.size()-1);
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
        int nodes[] = {3, 5, 6, 8, 10, 11, 12};
        Node root = null;
        for(int i=0; i<nodes.length; i++)
            root = insert(root, nodes[i]);
        root = balancedBST(root);
        System.out.print("Balanced BST: ");
        preorder(root);
        in.close();
    }
}
