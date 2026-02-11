import java.util.*;
public class SortedRotatedArray{
    public static int search(int arr[], int target) {
       int si = 0, ei = arr.length - 1;
       while(si <= ei){
         int mid = si + (ei - si)/2;
         if(arr[mid] == target)
            return mid;

         if(arr[si] <= arr[mid]){
            if(arr[si] <= target && target <= arr[mid])
                ei = mid - 1;
            else
                si = mid + 1;
         }
         else{
            if(arr[mid] <= target && target <= arr[ei])
                si = mid + 1;
            else
                ei = mid - 1;
         }
       }
       return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[7];
        System.out.print("Enter 7 elements: ");
        for(int i=0; i<7; i++)
            arr[i] = in.nextInt();
        System.out.print("Enter the target: ");
        int target = in.nextInt();
        System.out.println("Index of target element: " + search(arr, target));
        in.close();
    }
}


