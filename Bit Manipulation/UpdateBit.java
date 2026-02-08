import java.util.*;
public class UpdateBit {
    public static int clearbit (int n, int i) {
        return (n & ~ (1 << i));
    }

    public static int updatebit (int n, int i, int nb) {
        n = clearbit(n, i);
        return (n | nb << i);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int n = in.nextInt();
        System.out.print("Enter the ith position: ");
        int i = in.nextInt();
        System.out.print("Enter the new bit: ");
        int nb = in.nextInt();
        System.out.println("After updating the ith bit the digit becomes : " + updatebit(n, i, nb));
        in.close();
    }
}


