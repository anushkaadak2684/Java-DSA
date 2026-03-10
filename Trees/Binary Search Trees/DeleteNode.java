import java.util.*;
public class DeleteNode {
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
    public static Node findis(Node root){
        while(root.left != null)
            root = root.left;
        return root;
    }
    public static Node delete(Node root, int n){
        if(root == null)
            return null;

        if(root.data > n)
            root.left = delete(root.left, n);
        else if(root.data < n)
            root.right = delete(root.right, n);
        else{
            if(root.left == null & root.right == null)
                return null;

            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            else{
                Node is = findis(root.right);
                root.data = is.data;
                root.right = delete(root.right, is.data);
            }
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int i=0; i<nodes.length; i++)
            root = insert(root, nodes[i]);
        System.out.print("Enter node to be deleted: ");
        int n = in.nextInt();
        root = delete(root, n);
        System.out.print("Current BST: ");
        inorder(root);
        in.close();
    }
}

