import java.util.*;
public class WordBreak {
    public static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        Node(){
            for(int i=0; i<26; i++)
                children[i] = null;  
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            char ch = word.charAt(level);
            if(curr.children[ch-'a'] == null)
                curr.children[ch-'a'] = new Node();

            curr = curr.children[ch-'a'];
        }
        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr = root;
        for(int level=0; level<key.length(); level++){
            char ch = key.charAt(level);
            if(curr.children[ch-'a'] == null)
                return false;

            curr = curr.children[ch-'a'];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String key){
        if(key.length() == 0)
            return true;
        
        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0, i)) && wordBreak(key.substring(i)))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};

        for(int i=0; i<words.length; i++)
            insert(words[i]);
        System.out.print("Enter the word to be broken: ");
        String key = in.next();

        if(wordBreak(key))
            System.out.println(key + " can be broken into dictionary words");
        else
            System.out.println(key + " cannot be broken into dictionary words");
        in.close();;
    }
}