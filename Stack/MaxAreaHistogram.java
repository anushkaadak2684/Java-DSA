import java.util.*;
public class MaxAreaHistogram {
    public static int maxAreaHistogram(int arr[]){
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
        Stack <Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty())
                nsr[i] = arr.length;
            else
                nsr[i] = s.peek();
            s.push(i);
        }

        for(int i=0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty())
                nsl[i] = -1;
            else
                nsl[i] = s.peek();
            s.push(i);
        }

        int maxArea = 0;
        for(int i=0; i<arr.length; i++){
            int currArea = arr[i] * (nsr[i] - nsl[i] - 1);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[6];
        System.out.print("Enter the heights of the bars: ");
        for(int i=0; i<6; i++)
            arr[i] = in.nextInt();
        System.out.print("Maximum area in the histogram: " + maxAreaHistogram(arr));
        in.close();
    }
}
