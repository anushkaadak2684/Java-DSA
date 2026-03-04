import java.util.*;
public class FisrtNonRepeating {
    public static void firstNonRepeating(String str) {
       Queue <Character> q = new LinkedList<>();
       int freq[] = new int[26];
       String sb = "";
       System.out.println("String\t\tLetter ");
       for(int i=0; i<str.length(); i++){
        char ch = str.charAt(i);
        sb = sb + ch;
        q.add(ch);
        freq[ch-'a']++;
        while(!q.isEmpty() && (freq[q.peek()-'a'] > 1)){
            q.remove();
        }
        if(q.isEmpty())
            System.out.println(sb + "\t\t" + -1);
        else
            System.out.println(sb + "\t\t" + q.peek());
       }
    }
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String str = in.next();
    firstNonRepeating(str);
    in.close();
    } 
}
    
