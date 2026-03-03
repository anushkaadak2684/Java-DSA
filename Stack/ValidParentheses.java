import java.util.*;
public class ValidParentheses {
    public static boolean isValid(String str) {
        Stack <Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch =='(' || ch =='[' || ch =='{')
                s.push(ch);
            else{
                if(s.isEmpty())
                    return false;
                
                if((s.peek() == '(' && ch == ')') || (s.peek() == '[' && ch == ']') || (s.peek() == '{' && ch == '}'))
                    s.pop();
                else
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string containing only parentheses: ");
        String str = in.next();
        if(isValid(str))
            System.out.println(str + " contains valid parentheses");
        else
            System.out.println(str + " does not contain valid parentheses");
        in.close();
    }
}
