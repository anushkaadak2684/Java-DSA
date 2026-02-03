import java.util.*;
import java.util.Arrays;
public class InbuiltSort{
    public static void inbuiltSort(Integer arr[]){
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.print("Sorted array: ");
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer arr[] = new Integer[5];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i] = in.nextInt();
        inbuiltSort(arr);
        in.close();
    }
}
