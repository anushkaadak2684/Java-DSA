import java.util.*;
public class CoinChange {
    public static int coinChange(int coins[], int n, int sum, int dp[][]) {
        for(int i=0; i<dp.length; i++)
            dp[i][0] = 1;

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int v = coins[i-1];
                if(v <= j)
                    dp[i][j] = dp[i][j-v] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int coins[] = {1, 2, 3};

        System.out.print("Enter the target sum: ");
        int sum = in.nextInt();

        int dp[][] = new int[coins.length+1][sum+1];
        System.out.print("No. of ways: " + coinChange(coins, coins.length, sum, dp));
        in.close();
    }
}