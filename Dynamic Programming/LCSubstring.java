import java.util.*;
public class LCSubstring {
    public static int lcs(String str1, String str2, int n, int m, int dp[][]) {
        int ans = 0;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } 
                else
                    dp[i][j] = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two strings: ");
        String str1 = in.next();
        String str2 = in.next();

        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        System.out.print("Longest common substring: " + lcs(str1, str2, n, m, dp));
        in.close();
    }
}
