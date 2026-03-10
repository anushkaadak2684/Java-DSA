import java.util.*;
public class MergedBST {
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
    public static void inorder(ArrayList <Integer> inorder, Node root){
        if(root == null)
            return;
        inorder(inorder, root.left);
        inorder.add(root.data);
        inorder(inorder, root.right);
    }
    public static void mergeInorder(ArrayList <Integer> mergedInorder, ArrayList <Integer> inorder1, ArrayList <Integer> inorder2){
        int i=0, j=0;
        while(i < inorder1.size() && j < inorder2.size()){
            if(inorder1.get(i) < inorder2.get(j)){
                mergedInorder.add(inorder1.get(i));
                i++;
            }   
            else{
                mergedInorder.add(inorder2.get(j));
                j++;
            }     
        }
        while(i < inorder1.size()){
            mergedInorder.add(inorder1.get(i));
            i++;
        }   
        while(j < inorder2.size()){
            mergedInorder.add(inorder2.get(j));
            j++;
        } 
    }
    public static Node createBST(ArrayList <Integer> mergedInorder, int start, int end){
        if(start > end)
            return null;

        int mid = (start + end)/2;
        Node root = new Node(mergedInorder.get(mid));
        root.left = createBST(mergedInorder, start, mid-1);
        root.right = createBST(mergedInorder, mid+1, end);
        return root;
    }
    public static Node mergedBST(Node root1, Node root2){
        ArrayList <Integer> inorder1 = new ArrayList<>();
        ArrayList <Integer> inorder2 = new ArrayList<>();
        ArrayList <Integer> mergedInorder = new ArrayList<>();
        inorder(inorder1, root1);
        inorder(inorder2, root2);
        mergeInorder(mergedInorder,inorder1, inorder2);
        Node root = createBST(mergedInorder, 0, mergedInorder.size()-1);
        return root;
    }
    public static void preorder(Node root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes1[] = {1, 2, 4};
        int nodes2[] = {3, 9, 12};
        Node root1 = null;
        Node root2 = null;

        for(int i=0; i<nodes1.length; i++)
            root1 = insert(root1, nodes1[i]);
        for(int i=0; i<nodes2.length; i++)
            root2 = insert(root2, nodes2[i]);

        Node root = mergedBST(root1, root2);
        System.out.print("Merged BST: ");
        preorder(root);
        in.close();
    }
}
