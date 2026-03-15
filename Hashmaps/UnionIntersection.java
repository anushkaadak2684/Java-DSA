import java.util.*;
public class UnionIntersection {
    public static void findUI(int arr1[], int arr2[]){
        HashSet <Integer> hs = new HashSet<>();
        for(int i=0; i<arr1.length; i++)
            hs.add(arr1[i]);
        for(int i=0; i<arr2.length; i++)
            hs.add(arr2[i]);
        System.out.print("No. of unique elements: " + hs.size());

        hs.clear();
        for(int i=0; i<arr1.length; i++)
            hs.add(arr1[i]);

        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(hs.contains(arr2[i])){
                count++;
                hs.remove(arr2[i]);
            }
        }
        System.out.print("\nNo. of common elements: " + count);
    }
   public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr1[]=new int[5];
        int arr2[]=new int[5];
        System.out.print("Enter an array set: ");
        for(int i=0; i<arr1.length; i++)
            arr1[i]=in.nextInt();
        System.out.print("Enter another array set: ");
        for(int i=0; i<arr2.length; i++)
            arr2[i]=in.nextInt();
        findUI(arr1, arr2);
        in.close();
    } 
}
