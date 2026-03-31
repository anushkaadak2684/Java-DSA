import java.util.*;
public class TargetSumSubset {
    public static boolean targetSum(int val[], int n, int sum, boolean dp[][]) {
        for(int i=0; i<dp.length; i++)
            dp[i][0] = true;

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int v = val[i-1];
                if(v <= j && dp[i-1][j-v] == true)
                    dp[i][j] = true;
                else if(dp[i-1][j] == true)
                    dp[i][j] = true;
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int val[] = {4, 2, 7, 1, 3};

        System.out.print("Enter the target sum: ");
        int sum = in.nextInt();

        boolean dp[][] = new boolean[val.length+1][sum+1];

        if(targetSum(val, val.length, sum, dp))
            System.out.print("Targest sum subset exists....");
        else
            System.out.print("Targest sum subset does not exist");
        in.close();
    }
}