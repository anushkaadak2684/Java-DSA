public class DiameterOptimized {
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
    public static class Info {
        int dia;
        int height;
        public Info(int dia, int height){
            this.dia = dia;
            this.height = height;
        }
    }
    public static Info diameter(Node root) {
        if(root == null)
            return new Info(0, 0);
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int selfd = leftInfo.height + rightInfo.height + 1;
        int finald = Math.max(selfd, Math.max(leftInfo.dia, rightInfo.dia));
        int finalh = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(finald, finalh);
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.print("Diameter of the tree: " + diameter(root).dia);
    }
}