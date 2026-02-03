import java.util.*;
public class InsertionSort{
    public static void insertionSort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
        System.out.print("Sorted array: ");
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i] = in.nextInt();
        insertionSort(arr);
        in.close();
    }
}
