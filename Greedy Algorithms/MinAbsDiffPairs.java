import java.util.*;
public class MinAbsDiffPairs {
    public static void minTotalSum(int a[], int b[]){
        Arrays.sort(a);
        Arrays.sort(b);
        int minSum = 0;
        System.out.print("The min absolute difference pairs: ");
        for(int i=0; i<a.length; i++){
            minSum += Math.abs(a[i] - b[i]);
            System.out.print("("+a[i]+","+b[i]+")"+" ");
        }
        System.out.println("\nMin Absolute Difference Pair Sum: " + minSum);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of digits: ");
        int n = in.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        System.out.print("Enter digits for first array: ");
        for(int i=0; i<a.length; i++)
            a[i]=in.nextInt();
        System.out.print("Enter digits for second array: ");
        for(int i=0; i<b.length; i++)
            b[i]=in.nextInt();
        minTotalSum(a, b);
        in.close();
    }
}
