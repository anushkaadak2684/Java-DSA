import java.util.*;
public class BuildSegmentTree {
    public static int buildST(int arr[], int i, int start, int end, int tree[]){
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

    public static void print(int tree[]){
        for(int i=0; i<tree.length; i++)
            System.out.print(tree[i] + " ");
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
        print(tree);
        in.close();
    }
}
