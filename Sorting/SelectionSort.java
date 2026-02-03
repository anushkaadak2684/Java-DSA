import java.util.*;
public class SelectionSort{
    public static void selectionSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min] > arr[j])
                    min = j;
           }
           int temp = arr[min];
           arr[min] = arr[i];
           arr[i] = temp; 
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
        selectionSort(arr);
        in.close();
    }
}
