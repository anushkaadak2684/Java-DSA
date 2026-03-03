import java.util.*;
public class DuplicateParentheses {
    public static boolean isValid(String str) {
        Stack <Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            int count = 0;
            char ch = str.charAt(i);
            if(ch == ')'){
                while(s.pop() != '(')
                    count++;
                if(count < 1)
                    return true;
            }
            else
                s.push(ch);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an expression with parentheses: ");
        String str = in.next();
        if(isValid(str))
            System.out.println(str + " contains duplicate parentheses");
        else
            System.out.println(str + " does not contain duplicate parentheses");
        in.close();
    }
}

