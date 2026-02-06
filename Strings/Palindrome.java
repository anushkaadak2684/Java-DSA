import java.util.*;
public class Palindrome{
    public static boolean palindrome(String str){
        int n = str.length();
        for(int i=0; i<n/2; i++){
            if(str.charAt(i) != str.charAt(n-1-i))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str;
        System.out.print("Enter a string: ");
        str = in.next().toLowerCase();
        if(palindrome(str))
            System.out.println("Palindrome string");
        else
            System.out.println("NOT a Palindrome string");
        in.close();
    }
}

