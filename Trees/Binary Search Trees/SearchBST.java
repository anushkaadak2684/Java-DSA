import java.util.*;
public class SearchBST {
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
    public static boolean search(Node root, int key){
        if(root == null)
            return false;

        if(root.data == key)
            return true;
        else if(root.data > key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int i=0; i<nodes.length; i++)
            root = insert(root, nodes[i]);
        System.out.print("Enter key: ");
        int key = in.nextInt();
        if(search(root, key))
            System.out.println("Key found");
        else
            System.out.println("Key NOT found");
        in.close();
    }
}
