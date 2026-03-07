public class Subtree {
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
    public static class BinaryTree {
        static int idx = -1;
        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1 )
                return null;
            else{
                Node newNode = new Node(nodes[idx]);
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);
                return newNode;
            }
        }
    }
    public static boolean isIdentical(Node root, Node subroot) {
        if(root == null && subroot == null)
            return true;
        else if(root == null || subroot == null || root.data != subroot.data)
            return false;
        if(!isIdentical(root.left, subroot.left))
            return false;
        if(!isIdentical(root.right, subroot.right))
            return false;
        return true;
    }
    public static boolean isSubtree(Node root, Node subroot) {
        if(root == null)
            return false;
        if(root.data == subroot.data){
            if(isIdentical(root, subroot))
                return true;
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1};
        int subnodes[] = {2, 4, -1, -1, 5, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        BinaryTree.idx = -1;
        Node subroot = tree.buildTree(subnodes);
        if(isSubtree(root, subroot))
            System.out.println("The given tree has the given subtree");
        else
            System.out.println("The given tree does not have the given subtree");
    }
}


