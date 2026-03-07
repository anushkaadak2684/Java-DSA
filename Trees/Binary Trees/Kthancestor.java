import java.util.*;
public class Kthancestor {
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

    public static int ancestor(Node root, int n, int k){
        if(root == null)
            return -1;
        if(root.data == n)
            return 0;
        
        int leftDist = ancestor(root.left, n, k);
        int rightDist = ancestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1)
            return -1;
        
        int max = Math.max(leftDist, rightDist);
        if(max + 1 == k)
            return root.data;
        return max + 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.print("Enter n (1 to 7): ");
        int n = in.nextInt();
        System.out.print("Enter k (0 to 2): ");
        int k = in.nextInt();
        System.out.print("Kth ancestor of the node: " + ancestor(root, n, k));
        in.close();
    }
}
