import java.util.*;
public class WeakestSoldier {
    public static class Row implements Comparable<Row>{
        int count;
        int idx;
        public Row(int count, int idx){
            this.count = count;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row r){
            if(this.count == r.count)
                return this.idx - r.idx;
            else
                return this.count - r.count;
        }
    }
    public static void weakestSoldier(int army[][], int k){
        PriorityQueue <Row> pq = new PriorityQueue<>();
        for(int i=0; i<army.length; i++){
            int count = 0;
            for(int j=0; j<army[0].length; j++){
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }
        System.out.println("Weakest Rows:");
        for(int i=0; i<k; i++)
            System.out.println("R" + pq.remove().idx);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter m and n (m x n): ");
        int m = in.nextInt();
        int n = in.nextInt();
        int army[][] = new int[m][n];
        System.out.println("Enter 1 for soldier and 0 for civilian: ");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                army[i][j] = in.nextInt();
        }
        System.out.print("Enter k to find k weakest rows: ");
        int k = in.nextInt();
        weakestSoldier(army, k);
        in.close();
    }
}
