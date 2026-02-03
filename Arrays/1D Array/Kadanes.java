import java.util.*;
public class Kadanes{
    public static void kadanes(int arr[]){
        int currsum = 0, maxsum = Integer.MIN_VALUE, maxelement = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            currsum += arr[i];
            if(currsum < 0)
                currsum = 0;
            maxsum = Math.max(maxsum, currsum);
            maxelement = Math.max(maxelement, arr[i]);
        }
        if(maxsum > 0)
            System.out.println("Maximum Subarray Sum: "+ maxsum);
        else
            System.out.println("Maximum Subarray Sum: "+ maxelement);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i] = in.nextInt();
        kadanes(arr);
        in.close();
    }
}