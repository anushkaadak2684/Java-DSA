import java.util.*;
public class CountSetBits {
    public static int count (int n) {
        int c = 0;
        while(n > 0){
            if ((n & 1) != 0 )
                c++;
            n = n >>1;
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int n = in.nextInt();
        System.out.println("Number of set bits: " + count(n));
        in.close();
    }
}
