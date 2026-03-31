import java.util.*;
public class MCMtabulation {
    public static int mcm (int arr[], int dp[][]) {
        for(int i=0; i<dp[0].length; i++)
            dp[i][i] = 0;

        int n = arr.length;
        for(int len=2; len <= n-1; len++){
            for(int i=1; i <= n-len; i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j],cost1 + cost2 + cost3);
                }
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.print("Enter the array elements: ");
        for(int i=0; i<5; i++)
            arr[i] = in.nextInt();
        int dp[][] = new int[5][5];
        System.out.print("Minimum cost: " + mcm (arr, dp));
        in.close();;
    }
}
