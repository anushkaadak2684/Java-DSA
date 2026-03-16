import java.util.*;
public class StartsWith {
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

    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int level=0; level<prefix.length(); level++){
            char ch = prefix.charAt(level);
            if(curr.children[ch-'a'] == null)
                return false;

            curr = curr.children[ch-'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String words[] = {"the", "app", "there", "their", "any", "apple"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }
        System.out.print("Enter the prefix to be searched: ");
        String prefix = in.next();
        if(startsWith(prefix))
            System.out.println("Prefix found");
        else
            System.out.println("Prefix NOT found");
        in.close();
    }
}