import java.util.*;
public class GetBit {
    public static int getbit (int n, int i) {
        if ((n & 1 << i) == 0)
            return 0;
        else
            return 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int n = in.nextInt();
        System.out.print("Enter the ith position: ");
        int i = in.nextInt();
        System.out.println("The ith bit is : " + getbit(n, i));
        in.close();
    }
}
