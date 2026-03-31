import java.util.*;
public class UnboundedKnapsack {
    public static int maxProfit(int val[], int wt[], int n, int W, int dp[][]) {
        for(int i=0; i<dp.length; i++)
            dp[i][0] = 0;
        for(int j=0; j<dp[0].length; j++)
            dp[0][j] = 0;

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){
                    int ans1 = v + dp[i][j-w];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};

        System.out.print("Enter the weight of the knapsack: ");
        int W = in.nextInt();

        int dp[][] = new int[val.length+1][W+1];
        System.out.print("Maximum profit: " + maxProfit(val, wt, val.length, W, dp));
        in.close();
    }
}
