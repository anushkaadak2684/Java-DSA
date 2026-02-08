import java.util.*;
public class ClearBitsRange {
    public static int clearLastbits (int n, int i, int j) {
        int a = ~ 0 << (j + 1);
        int b = (1 << i) - 1;
        return n & (a | b);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int n = in.nextInt();
        System.out.print("Enter the ith (smaller) position: ");
        int i = in.nextInt();
        System.out.print("Enter the jth (larger) position: ");
        int j = in.nextInt();
        System.out.println("After clearing the bits the digit becomes : " + clearLastbits(n, i, j));
        in.close();
    }
}




