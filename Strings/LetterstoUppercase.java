import java.util.*;
public class LetterstoUppercase{
    public static void toUppercase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else
                sb.append(str.charAt(i));
        }
        str = sb.toString();
        System.out.println("Resulted string: " + str);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str;
        System.out.print("Enter a string: ");
        str = in.nextLine();
        toUppercase(str);
        in.close();
    }
}


