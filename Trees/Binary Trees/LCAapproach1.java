import java.util.*;
public class LCAapproach1 {
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
    public static boolean getpath(Node root, int n, ArrayList <Node> path){
        if(root == null)
            return false;

        path.add(root);

        if(root.data == n)
            return true;

        boolean foundLeft = getpath(root.left, n, path);
        boolean foundRight = getpath(root.right, n, path);

        if(foundLeft || foundRight)
            return true;

        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2) {
        ArrayList <Node> path1 = new ArrayList<>();
        ArrayList <Node> path2 = new ArrayList<>();

        getpath(root, n1, path1);
        getpath(root, n2, path2);

        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++ ){
            if(path1.get(i) != path2.get(i))
                break;
        }
        Node lca = path1.get(i-1);
        return lca;
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
