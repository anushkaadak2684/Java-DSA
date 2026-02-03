import java.util.*;
public class Largest{
    public static void largest(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>largest)
                largest=arr[i];
        }
        System.out.print("Largest number: "+ largest);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr[]=new int[5];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i]=in.nextInt();
        largest(arr);
        in.close();
    }
}
