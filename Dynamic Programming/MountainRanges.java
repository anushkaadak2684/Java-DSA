import java.util.*;
public class MountainRanges {
    public static int countMountain (int n, int dp[]) {
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++)
                dp[i] += dp[j] * dp[i-j-1];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of pair strokes: ");
        int n = in.nextInt();
        int dp[] = new int[n+1];
        System.out.print("No. of Mountain Ranges: " + countMountain (n, dp));
        in.close();;
    }
}