import java.util.*;
public class Fibonacci {
    public static int fib(int n, int dp[]) {
        if(n == 0 || n == 1)
            return n;

        if(dp[n] !=0)
            return dp[n];
        else
            return dp[n] = fib(n-1, dp) + fib(n-2, dp);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();

        int dp[] = new int[n+1];
        System.out.print("Fibonacci number: " + fib(n, dp));
        in.close();;
    }
}
