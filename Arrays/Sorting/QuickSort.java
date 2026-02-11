import java.util.*;
public class QuickSort{
    public static int partition(int arr[], int si, int ei) {
       int pivot = arr[ei], i = si-1, temp;
       for(int j=si; j<ei; j++){
        if(arr[j] < pivot){
            i++;
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
       }
       i++;
       temp = arr[i];
       arr[i] = arr[ei];
       arr[ei] = temp;
       return i; 
    }
    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei)
            return;
        int pidx = partition(arr, si, ei);;
        quickSort(arr, si, pidx - 1);
        quickSort(arr, pidx + 1, ei);
    }
    public static void printArray(int arr[]){
        System.out.print("Sorted array: ");
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.print("Enter an array: ");
        for(int i=0; i<5; i++)
            arr[i] = in.nextInt();
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
        in.close();
    }
}

