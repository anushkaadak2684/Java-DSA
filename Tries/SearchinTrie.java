import java.util.*;
public class SearchinTrie {
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

    public static boolean search(String key){
        Node curr = root;
        for(int level=0; level<key.length(); level++){
            char ch = key.charAt(level);
            if(curr.children[ch-'a'] == null)
                return false;

            curr = curr.children[ch-'a'];
        }
        return curr.endOfWord == true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }
        System.out.print("Enter the word to be searched: ");
        String key = in.next();
        if(search(key))
            System.out.println("Key found");
        else
            System.out.println("Key NOT found");
        in.close();
    }
}