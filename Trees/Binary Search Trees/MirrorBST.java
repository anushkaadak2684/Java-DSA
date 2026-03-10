public class MirrorBST {
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
    public static Node mirror(Node root){
        if(root == null)
            return null;
        Node leftChild = mirror(root.left);
        Node rightChild = mirror(root.right);
        root.left = rightChild;
        root.right = leftChild;
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
        int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for(int i=0; i<nodes.length; i++)
            root = insert(root, nodes[i]);
        System.out.print("Original BST: ");
        inorder(root);
        root = mirror(root);
        System.out.print("\nMirror BST: ");
        inorder(root);
    }
}
