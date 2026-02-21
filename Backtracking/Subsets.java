import java.util.*;
public class Subsets{
    public static void findSubsets(String str, int i, String ans){
        if(i == str.length()){
            System.out.println(ans);
            return;
        }
        findSubsets(str, i+1, ans+str.charAt(i));
        findSubsets(str, i+1, ans);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.next();
        System.out.println("Subsets of the given string are: ");
        findSubsets(str, 0, "");
        in.close();
    }
}