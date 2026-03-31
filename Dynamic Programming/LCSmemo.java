import java.util.*;
public class LCSmemo {
    public static int lcs(String str1, String str2, int n, int m, int dp[][]) {
        if(n == 0 || m == 0)
            return 0;

        if(dp[n][m] != -1)
            return dp[n][m];
        
        if(str1.charAt(n-1) == str2.charAt(m-1))
            return dp[n][m] = lcs(str1, str2, n-1, m-1, dp) + 1;
        else {
            int ans1 = lcs(str1, str2, n-1, m, dp);
            int ans2 = lcs(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two strings: ");
        String str1 = in.next();
        String str2 = in.next();

        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<dp.length; i++)
            Arrays.fill(dp[i], -1);

        System.out.print("Longest common subsequence: " + lcs(str1, str2, n, m, dp));
        in.close();
    }
}
