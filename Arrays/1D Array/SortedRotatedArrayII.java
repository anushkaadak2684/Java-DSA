import java.util.*;
public class SortedRotatedArrayII{
    public static int search(int arr[], int target, int si, int ei) {
       if(si > ei)
            return -1;
       
       int mid = si + (ei-si)/2;
       if(arr[mid] == target)
            return mid;

       if(arr[si] <= arr[mid]){
        if(arr[si] <= target && target <= arr[mid])
            return search(arr, target, si, mid-1);
        else
            return search(arr, target, mid+1, ei);
       }
       else{
        if(arr[mid] <= target && target <= arr[ei])
            return search(arr, target, mid+1, ei);
        else
            return search(arr, target, si, mid-1);
       }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[7];
        System.out.print("Enter 7 elements: ");
        for(int i=0; i<7; i++)
            arr[i] = in.nextInt();
        System.out.print("Enter the target: ");
        int target = in.nextInt();
        int idx = search(arr, target, 0, arr.length-1);
        System.out.println("Index of target element: " + idx);
        in.close();
    }
}


