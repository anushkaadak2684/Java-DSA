import java.util.*;
public class BinarySearch{
    public static void binarySearch(int arr[], int key){
        int start=0, end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){
                System.out.print("Item found");
                return;
            }
            else if(arr[mid]>key)
                end=mid-1;
            else 
                start=mid+1;
        }
        System.out.println("NOT found");
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr[]=new int[5];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i]=in.nextInt();
        System.out.print("Enter the number to be searched: ");
        int key=in.nextInt();
        binarySearch(arr, key);
        in.close();
    }
}
