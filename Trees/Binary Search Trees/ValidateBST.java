public class ValidateBST {
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
    public static boolean isValid(Node root, Node min, Node max){
        if(root == null)
            return true;
        else if(min != null && root.data <= min.data)
            return false;
        else if(max != null && root.data >= max.data)
            return false;

        return isValid(root.left, min, root) && isValid(root.right, root, max);
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
        inorder(root);
        if(isValid(root, null, null))
            System.out.print("\nBST is valid");
        else
            System.out.print("\nBST is NOT valid"); 
    }
}
