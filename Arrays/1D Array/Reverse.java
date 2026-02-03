import java.util.*;
public class Reverse{
    public static void reverse(int arr[]){
        int start=0, end=arr.length-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++; end--;
        }
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr[]=new int[5];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i]=in.nextInt();
        reverse(arr);
        in.close();
    }
}

