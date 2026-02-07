import java.util.*;
public class EvenOdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int n = in.nextInt();
        if ((n & 1) == 0)
            System.out.println("Even digit");
        else
            System.out.println("Odd digit");
        in.close();
    }
}
