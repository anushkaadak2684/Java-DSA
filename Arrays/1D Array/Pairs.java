import java.util.*;
public class Pairs{
    public static void printPairs(int arr[]){
        int tp=0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                System.out.println("("+arr[i]+","+arr[j]+")");
                tp++;
            }
        }
        System.out.println("Total number of pairs: "+tp);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr[]=new int[5];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i]=in.nextInt();
        printPairs(arr);
        in.close();
    }
}


