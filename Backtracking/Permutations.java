import java.util.*;
public class Permutations{
    public static void findPermutations(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String newstr = str.substring(0,i) + str.substring(i+1);
            findPermutations(newstr, ans+curr);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.next();
        System.out.println("Permutations of the given string are: ");
        findPermutations(str, "");
        in.close();
    }
}