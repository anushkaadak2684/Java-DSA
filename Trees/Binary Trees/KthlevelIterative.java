import java.util.*;
public class KthlevelIterative {
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
    public static void kthlevel(Node root, int level, int k) {
        Queue <Node> q = new LinkedList<>();
        if(root == null)
            return;
        q.add(root);
        q.add(null);
        while(! q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                level++;
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else{
                if(level == k)
                    System.out.print(curr.data + " ");
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.print("Enter k (0 to 2): ");
        int k = in.nextInt();
        kthlevel(root, 0, k);
        in.close();
    }
}
