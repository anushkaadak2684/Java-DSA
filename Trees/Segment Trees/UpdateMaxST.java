import java.util.*;
public class UpdateMaxST {
    public static int buildST(int arr[], int i, int start, int end, int tree[]){
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end)/2;
        buildST(arr, 2*i+1, start, mid, tree);
        buildST(arr, 2*i+2, mid+1, end, tree);
        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
        return tree[i];
    }

    public static void print(int tree[]){
        for(int i=0; i<tree.length; i++)
            System.out.print(tree[i] + " ");
    }

    public static void updateSTUtil (int tree[], int i, int si, int sj, int idx, int newVal){
        if(si == sj) {
            tree[i] = newVal;
            return;
        }

        int mid = (si + sj)/2;
        if(idx <= mid)
            updateSTUtil(tree, 2*i+1, si, mid, idx, newVal);
        else
            updateSTUtil(tree, 2*i+2, mid+1, sj, idx, newVal);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    public static void updateST (int tree[], int arr[], int idx, int newVal){
        if(idx < 0 || idx >= arr.length){
            System.out.println("Invalid index!");
            return;
        }
        arr[idx] = newVal;
        updateSTUtil(tree, 0, 0, arr.length-1, idx, newVal);
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

        System.out.print("\nEnter the index to be replaced (0-7): ");
        int idx = in.nextInt();
        System.out.println("Enter the new value: ");
        int newVal = in.nextInt();

        updateST(tree, arr, idx, newVal);
        print(tree);
        in.close();
    }
}

