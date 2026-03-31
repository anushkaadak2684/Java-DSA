import java.util.*;
public class CatalansNum {
    public static int catalans (int n, int dp[]) {
        if(n == 0 || n == 1)
            return 1;

        if(dp[n] != 0)
            return dp[n];
        
        for(int i=0; i<n; i++){
            dp[n] +=  catalans (i, dp) *  catalans (n-i-1, dp); 
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        int dp[] = new int[n+1];
        System.out.print("Catalans number: " + catalans (n, dp));
        in.close();;
    }
}
