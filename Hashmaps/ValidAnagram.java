import java.util.*;
public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;

        HashMap <Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two strings: ");
        String s = in.next();
        String t = in.next();
        if(isAnagram(s, t))
            System.out.println(t + " is a valid anagram of " + s);
        else
            System.out.println(t + " is a NOT valid anagram of " + s);
        in.close();
    }
}
