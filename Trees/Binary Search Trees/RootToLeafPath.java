import java.util.*;
public class RootToLeafPath {
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
    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++)
            System.out.print(path.get(i) + " ");
        System.out.println();
    }
    public static void findpaths(Node root, ArrayList<Integer> path){
        if(root == null)
            return;

        path.add(root.data);
        if(root.left == null && root.right == null)
            printPath(path);

        findpaths(root.left, path);
        findpaths(root.right, path);
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for(int i=0; i<nodes.length; i++)
            root = insert(root, nodes[i]);
        System.out.println("Root to Leaf Paths: ");
        findpaths(root, new ArrayList<>());
    }
}
