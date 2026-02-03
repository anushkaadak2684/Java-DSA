import java.util.*;
public class PrefixSum{
    public static void prefixSum(int arr[]){
        int prefix[] = new int[5];
        int maxsum = Integer.MIN_VALUE, currsum=0;
        prefix[0] = arr[0];
        for(int i=1; i<arr.length; i++)
            prefix[i] = prefix[i-1] + arr[i];

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                currsum = (i==0)? prefix[j] : prefix[j] - prefix[i-1];
            }
            System.out.println(currsum);
                if(currsum>maxsum)
                    maxsum=currsum;
        }
        System.out.println("Maximum Subarray Sum: "+ maxsum);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i] = in.nextInt();
        prefixSum(arr);
        in.close();
    }
}




