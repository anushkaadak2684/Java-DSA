import java.util.*;
public class ClearBit {
    public static int clearbit (int n, int i) {
        return (n & ~ (1 << i));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int n = in.nextInt();
        System.out.print("Enter the ith position: ");
        int i = in.nextInt();
        System.out.println("After clearing the ith bit the digit becomes : " + clearbit(n, i));
        in.close();
    }
}

