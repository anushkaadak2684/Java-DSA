import java.util.*;
public class MaxLengthChain {
    public static void maxLengthChain(int arr[][]) {
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[2]));
        int maxLen = 0;
        ArrayList <Integer> chain = new ArrayList<>();
        maxLen++;
        chain.add(arr[0][0]);
        int lastEnd = arr[0][2];
        for(int i=1; i<arr.length; i++){
            if(arr[i][1] > lastEnd){
                maxLen++;
                chain.add(arr[i][0]);
                lastEnd = arr[i][2];
            }
        }
        System.out.println("Maximum length chain of pairs: " + maxLen);
        System.out.print("The pairs are: ");
        for(int i=0; i<chain.size(); i++)
            System.out.print(chain.get(i) + "th ");
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of pairs: ");
        int n = in.nextInt();
        int arr[][] = new int[n][3];
        System.out.println("Enter the pairs: ");
        for(int i=0; i<n; i++){
            arr[i][0] = i;
            for(int j=1; j<3; j++){
                arr[i][j]=in.nextInt();
            }
        }
        maxLengthChain(arr);
        in.close();
    }
}
