import java.util.*;
public class MCMmemo {
    public static int mcm (int arr[], int i, int j, int dp[][]) {
        if(i == j)
            return 0;

        if(dp[i][j] != 0)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int cost1 = mcm(arr, i, k, dp);
            int cost2 = mcm(arr, k+1, j, dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            ans = Math.min(ans,cost1 + cost2 + cost3);
        }
        return dp[i][j] = ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.print("Enter the array elements: ");
        for(int i=0; i<5; i++)
            arr[i] = in.nextInt();
        int dp[][] = new int[5][5];
        System.out.print("Minimum cost: " + mcm (arr, 1, arr.length-1, dp));
        in.close();;
    }
}
