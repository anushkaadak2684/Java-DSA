import java.util.*;
public class SlidingWindowMax {
    public static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair p){
            return p.val - this.val;
        }
    }
    public static void slidingWindow(int arr[], int k){
        PriorityQueue <Pair> pq = new PriorityQueue<>();
        int result[] = new int[arr.length-k+1];
        for(int i=0; i<k; i++)
            pq.add(new Pair(arr[i], i));

        result[0] = pq.peek().val;
        for(int i=k; i<arr.length; i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k))
                pq.remove();
            
            pq.add(new Pair(arr[i], i));
            result[i-k+1] = pq.peek().val;
        }

        System.out.print("Maximum elements are: ");
        for(int i=0; i<result.length; i++)
            System.err.print(result[i] + " ");

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of elements: ");
        int n = in.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0; i<n; i++)
            arr[i] = in.nextInt();
        System.err.print("Enter the window size: ");
        int k = in.nextInt();
        slidingWindow(arr, k);
        in.close();
    }
}
