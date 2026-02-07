import java.util.*;
public class PowerofTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int n = in.nextInt();
        if ((n & n-1) == 0)
            System.out.println("Power of 2");
        else
            System.out.println("NOT a Power of 2");
        in.close();
    }
}