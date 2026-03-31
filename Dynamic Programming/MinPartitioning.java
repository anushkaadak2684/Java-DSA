import java.util.*;
public class MinPartitioning {
    public static int minDiff (int arr[], int sum, int dp[][]) {
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(arr[i-1] <= j){
                    int ans1 = arr[i-1] + dp[i-1][j-arr[i-1]];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[arr.length][sum];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[4];
        int sum=0;
        System.out.print("Enter the array elements: ");
        for(int i=0; i<4; i++){
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        int dp[][] = new int[arr.length+1][sum/2+1];
        int sum1 = minDiff (arr, sum/2, dp);
        int sum2 = sum - sum1;
        int diff = Math.abs(sum1 - sum2);
        System.out.print("Minimum difference: " + diff);
        in.close();;
    }
}
