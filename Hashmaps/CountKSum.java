import java.util.*;
public class CountKSum {
    public static int kSum(int arr[], int k){
        HashMap <Integer, Integer> map = new HashMap<>();
        int sum=0, count=0;
        map.put(0, 1);
        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum-k))
                count += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of elements: ");
        int n = in.nextInt();
        int arr[]=new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0; i<arr.length; i++)
            arr[i]=in.nextInt();
        System.out.print("Enter k (sum): ");
        int k = in.nextInt();
        System.out.print("No. of subarrays with k sum: " + kSum(arr, k));
        in.close();
    }
}
