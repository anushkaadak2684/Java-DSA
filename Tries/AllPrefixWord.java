public class AllPrefixWord {
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

    public static String ans = "";

    public static String findLongest(Node root, StringBuilder temp){
        if(root == null)
            return null;

        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length())
                    ans = temp.toString();
                findLongest(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String words[] = {"a", "banana", "ap", "app", "appl", "apple"};
        for(int i=0; i<words.length; i++)
            insert(words[i]);
        String ans = findLongest(root, new StringBuilder());
        System.out.print("Longest word with all prefix: " + ans);
    }
}
