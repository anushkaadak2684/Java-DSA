import java.util.*;
public class LinearSearch{
    public static void linearSearch(int arr[], int key){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==key){
                System.out.println("Item found");
                return;
            }
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
        linearSearch(arr, key);
        in.close();
    }
}