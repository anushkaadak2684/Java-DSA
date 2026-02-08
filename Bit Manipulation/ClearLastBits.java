import java.util.*;
public class ClearLastBits {
    public static int clearLastbits (int n, int i) {
        return (n & ((~ 0) << i));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int n = in.nextInt();
        System.out.print("Enter the ith position: ");
        int i = in.nextInt();
        System.out.println("After clearing the last i bits the digit becomes : " + clearLastbits(n, i));
        in.close();
    }
}



