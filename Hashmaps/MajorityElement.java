import java.util.*;
public class MajorityElement{
    public static void findMajority(int arr[]){
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Integer key: map.keySet()){
            if(map.get(key) > arr.length/3)
                System.err.print(key + " ");
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr[]=new int[10];
        System.out.print("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++)
            arr[i]=in.nextInt();
        System.out.print("The majority elements: ");
        findMajority(arr);
        in.close();
    }
}
