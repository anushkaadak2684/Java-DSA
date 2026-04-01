import java.util.*;
public class GetSumST {
    public static int buildST (int arr[], int i, int start, int end, int tree[]) {
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end)/2;
        buildST(arr, 2*i+1, start, mid, tree);
        buildST(arr, 2*i+2, mid+1, end, tree);
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    public static int getSumUtil (int i, int tree[], int qi, int qj, int si, int sj) {
        if(qj <= si || qi >= sj)
            return 0;
        else if(si >= qi && sj <= qj)
            return tree[i];
        else {
            int mid = (si + sj)/2;
            return getSumUtil(2*i+1, tree, qi, qj, si, mid) + getSumUtil(2*i+2, tree, qi, qj, mid+1, sj);
        }
    }
    public static int getSum (int arr[], int tree[], int qi, int qj) {
        return getSumUtil(0, tree, qi, qj, 0, arr.length-1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[8];
        System.out.print("Enter array elements: ");
        for(int i=0; i<8; i++){
            arr[i] = in.nextInt();
        }

        int n = arr.length;
        int tree[] = new int[4*n];
        buildST(arr, 0, 0, n-1, tree);

        System.out.print("Enter the range to calculate sum: ");
        int qi = in.nextInt();
        int qj = in.nextInt();
        System.out.print("Sum in the given range: " + getSum(arr, tree, qi, qj));
        in.close();
    }
}



