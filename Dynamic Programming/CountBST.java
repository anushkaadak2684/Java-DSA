import java.util.*;
public class CountBST{
    public static int countBST (int n, int dp[]) {
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
        System.out.print("Enter no. of nodes: ");
        int n = in.nextInt();
        int dp[] = new int[n+1];
        System.out.print("No. of BST: " + countBST (n, dp));
        in.close();;
    }
}
