import java.util.*;
public class UniqueSubstrings {
    public static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;
        Node(){
            for(int i=0; i<26; i++)
                children[i] = null;
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            char ch = word.charAt(level);
            if(curr.children[ch-'a'] == null)
                curr.children[ch-'a'] = new Node();

            curr = curr.children[ch-'a'];
        }
        curr.endOfWord = true;
    }

    public static int countNodes(Node root){
        if(root == null)
            return 0;

        int count=0;
        for(int i=0; i<26; i++){
            if(root.children[i] != null)
                count += countNodes(root.children[i]);
        }
        return count + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = in.next();
        for(int i=0; i<str.length(); i++){
            String substr = str.substring(i);
            insert(substr);
        }
        System.out.print("No. of unique substrings: " + countNodes(root));
        in.close();
    }
}