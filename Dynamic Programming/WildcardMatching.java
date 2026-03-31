import java.util.*;
public class WildcardMatching {
    public static boolean isMatching(String s, String p, int n, int m, boolean dp[][]) {
        dp[0][0] = true;
        for(int i=1; i<n+1; i++)
            dp[i][0] = false;
        for(int j=1; j<m+1; j++){
            if(p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-1];
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = in.next();
        System.out.print("Enter the pattern: ");
        String p = in.next();

        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];

        if(isMatching(s, p, n, m, dp))
            System.out.print("The given string matches the pattern");
        else
            System.out.print("The given string does not match the pattern");
        in.close();
    }
}
