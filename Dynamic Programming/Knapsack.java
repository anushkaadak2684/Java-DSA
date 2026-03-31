import java.util.*;
public class Knapsack {
    public static int maxProfit(int val[], int wt[], int w, int n, int dp[][]) {
        if(w == 0 || n == 0)
            return 0;

        if(dp[n][w] != -1)
            return dp[n][w];
        
        if(wt[n-1] <= w){
            int ans1 = val[n-1] + maxProfit(val, wt, w - wt[n-1], n - 1, dp);
            int ans2 = maxProfit(val, wt, w, n - 1, dp);
            return dp[n][w] = Math.max(ans1, ans2);
        } else {
            return dp[n][w] = maxProfit(val, wt, w, n - 1, dp);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};

        System.out.print("Enter the weight of the knapsack: ");
        int w = in.nextInt();

        int dp[][] = new int[val.length+1][w+1];
        for(int i=0; i<dp.length; i++)
            Arrays.fill(dp[i], -1);

        System.out.print("Maximum profit: " + maxProfit(val, wt, w, val.length, dp));
        in.close();
    }
}
