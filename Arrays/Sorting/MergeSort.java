import java.util.*;
public class MergeSort{
    public static void merge(int arr[], int si, int mid, int ei) {
        int i=si, j=mid + 1, k=0;
        int temp[] = new int[ei-si+1];
        while(i <= mid && j <= ei){
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= ei){
            temp[k++] = arr[j++];
        }
        for(i=si, k=0 ; k<temp.length ; k++, i++){
            arr[i] = temp[k];
        }
    }
    public static void mergeSort(int arr[], int si, int ei){
        if(si >= ei)
            return;
        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
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
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
        in.close();
    }
}
