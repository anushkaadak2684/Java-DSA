import java.util.*;
public class LargestZeroSum {
    public static int zeroSum(int arr[]){
        HashMap <Integer, Integer> map = new HashMap<>();
        int sum=0, len=0;
        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum))
                len = Math.max(len, j - map.get(sum));
            else
                map.put(sum, j);
        }
        return len;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of elements: ");
        int n = in.nextInt();
        int arr[]=new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0; i<arr.length; i++)
            arr[i]=in.nextInt();
        System.out.print("Largest subarray with zero sum: " + zeroSum(arr));
        in.close();
    }
}