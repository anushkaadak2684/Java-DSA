import java.util.*;
public class FastExponentiation {
    public static int exponent (int a, int n) {
        int ans=1;
        while(n>0){
            if((n & 1) != 0)
                ans*=a;
            a*=a;
            n = n >> 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int a = in.nextInt();
        System.out.print("Enter an exponent: ");
        int n = in.nextInt();
        System.out.println("The result : " + exponent(a, n));
        in.close();
    }
}



