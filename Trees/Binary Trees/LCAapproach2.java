import java.util.*;
public class LCAapproach2 {
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

    public static Node lca(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2)
            return root;

        Node leftlca = lca(root.left, n1, n2);
        Node rightlca = lca(root.right, n1, n2);

        if(leftlca == null)
            return rightlca;
        if(rightlca == null)
            return leftlca;
        return root;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.print("Enter n1 and n2 (1 to 6): ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        Node lca = lca(root, n1, n2);
        System.out.print("Lowest Common Ancestor: " + lca.data);
        in.close();
    }
}
