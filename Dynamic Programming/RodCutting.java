import java.util.*;
public class RodCutting {
    public static int maxProfit(int len[], int price[], int n, int totLen, int dp[][]) {
        for(int i=0; i<dp.length; i++)
            dp[i][0] = 0;
        for(int j=0; j<dp[0].length; j++)
            dp[0][j] = 0;

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int v = price[i-1];
                int l = len[i-1];
                if(l <= j){
                    int ans1 = v + dp[i][j-l];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][totLen];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.print("Enter the total length of the rod: ");
        int totLen = in.nextInt();

        int dp[][] = new int[len.length+1][totLen+1];
        System.out.print("Maximum profit: " + maxProfit(len, price, len.length, totLen, dp));
        in.close();
    }
}

