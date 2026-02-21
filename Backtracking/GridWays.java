import java.util.*;
public class GridWays{
    public static int gridWays(int i, int j, int n, int m){
        if(i == n-1 && j == m-1)
            return 1;
        else if(i == n || j == m)
            return 0;

        return gridWays(i+1, j, n, m) + gridWays(i, j+1, n, m);
        }
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = in.nextInt();
        System.out.print("Enter value of m: ");
        int m = in.nextInt();
        System.out.print("Total number of ways: " + gridWays(0, 0, n, m));
        in.close();
    }
}