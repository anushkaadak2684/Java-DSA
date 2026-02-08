import java.util.*;
public class SetBit {
    public static int setbit (int n, int i) {
        return (n | 1 << i);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int n = in.nextInt();
        System.out.print("Enter the ith position: ");
        int i = in.nextInt();
        System.out.println("After setting the ith bit the digit becomes : " + setbit(n, i));
        in.close();
    }
}

