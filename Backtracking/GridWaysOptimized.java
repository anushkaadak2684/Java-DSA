import java.util.*;
public class GridWaysOptimized{
      public static int fact(int n){
        if(n == 0 || n == 1)
            return 1;
        return n*fact(n-1);
      }
      public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = in.nextInt();
        System.out.print("Enter value of m: ");
        int m = in.nextInt();
        int ways = fact(n+m-2)/(fact(n-1)*fact(m-1));
        System.out.print("Total number of ways: " + ways);
        in.close();
    }
}
