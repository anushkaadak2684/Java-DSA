import java.util.*;
public class StringCompression{
    public static void compress(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            int count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1)
                sb.append(count);
        }
        str = sb.toString();
        System.out.println("Resulted string: " + str);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str;
        System.out.print("Enter a string: ");
        str = in.nextLine();
        compress(str);
        in.close();
    }
}
