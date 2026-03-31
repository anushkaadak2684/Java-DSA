import java.util.*;
public class StringConversion {
    public static int lcs(String str1, String str2, int n, int m, int dp[][]) {
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two strings: ");
        String str1 = in.next();
        String str2 = in.next();

        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        int lcs = lcs(str1, str2, n, m, dp);

        System.out.println("No. of deletions: " + (n - lcs));
        System.out.println("No. of insertions: " + (m - lcs));
        in.close();
    }
}
