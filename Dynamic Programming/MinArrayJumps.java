import java.util.*;
public class MinArrayJumps {
    public static int minJumps (int arr[],int dp[]) {
        int n = arr.length;
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            int ans = Integer.MAX_VALUE;
            for(int j=i+1; j <= i+arr[i] && j<n; j++){
                if(dp[j] != -1)
                    ans = Math.min(ans, dp[j] + 1);
            }
            if(ans != Integer.MAX_VALUE)
                dp[i] = ans;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.print("Enter the array elements: ");
        for(int i=0; i<5; i++){
            arr[i] = in.nextInt();
        }
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.print("Minimum array jumps: " + minJumps(arr, dp));
        in.close();;
    }
}
