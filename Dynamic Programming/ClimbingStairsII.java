import java.util.*;
public class ClimbingStairsII {
    public static int countWays(int n, int dp[]) {
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            if(i == 1)
                dp[i] = dp[i-1] + 0;
            else
                dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter nth stair: ");
        int n = in.nextInt();

        int dp[] = new int[n+1];
        System.out.print("No. of ways: " + countWays(n, dp));
        in.close();;
    }
}
