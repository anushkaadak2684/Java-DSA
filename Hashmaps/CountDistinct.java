import java.util.*;
public class CountDistinct {
    public static int distinct(int arr[]){
        HashSet <Integer> hs = new HashSet<>();
        for(int i=0; i<arr.length; i++)
            hs.add(arr[i]);
        return hs.size();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr[]=new int[10];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i]=in.nextInt();
        System.out.print("No. of distinct elements: " + distinct(arr));
        in.close();
    }
}
