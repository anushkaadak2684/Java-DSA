import java.util.*;
public class ClimbingStairs {
    public static int countWays(int n, int dp[]) {
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;

        if(dp[n] != -1)
            return dp[n];
        else
            return dp[n] = countWays(n-1, dp) + countWays(n-2, dp);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter nth stair: ");
        int n = in.nextInt();

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.print("No. of ways: " + countWays(n, dp));
        in.close();;
    }
}
