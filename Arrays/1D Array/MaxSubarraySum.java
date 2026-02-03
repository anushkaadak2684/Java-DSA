import java.util.*;
public class MaxSubarraySum{
    public static void maxSubarraySum(int arr[]){
        int maxsum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int currsum=0;
                for(int k=i; k<=j; k++){
                    currsum+=arr[k];
                }
                System.out.println(currsum);
                if(currsum>maxsum)
                    maxsum=currsum;
            }
        }
        System.out.println("Maximum Subarray Sum: "+ maxsum);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i]=in.nextInt();
        maxSubarraySum(arr);
        in.close();
    }
}



