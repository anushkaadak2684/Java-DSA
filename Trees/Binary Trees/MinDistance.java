import java.util.*;
public class MinDistance {
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

    public static int getDist(Node lca, int n){
        if(lca == null)
            return -1;
        if(lca.data == n)
            return 0;
        
        int leftDist = getDist(lca.left, n);
        int rightDist = getDist(lca.right, n);

        if(leftDist == -1 && rightDist == -1)
            return -1;
        else if(leftDist == -1)
            return rightDist + 1;
        else
            return leftDist + 1;
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int Dist1 = getDist(lca, n1);
        int Dist2 = getDist(lca, n2);
        return Dist1 + Dist2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.print("Enter n1 and n2 (1 to 7): ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        System.out.print("Minimum distance between the nodes: " + minDist(root, n1, n2));
        in.close();
    }
}
