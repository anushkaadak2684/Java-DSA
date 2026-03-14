import java.util.*;
public class NearbyCars {
    public static class Points implements Comparable<Points>{
        int distSq;
        int idx;
        public Points(int distSq, int idx){
            this.distSq = distSq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Points p){
            return this.distSq - p.distSq;
        }
    }
    public static void nearbyCars(int cars[][], int k){
        PriorityQueue <Points> pq = new PriorityQueue<>();
        for(int i=0; i<cars.length; i++){
            int distSq = cars[i][0]*cars[i][0] + cars[i][1]*cars[i][1];
            pq.add(new Points(distSq, i));
        }
        System.out.println("Nearby Cars:");
        for(int i=0; i<k; i++)
            System.out.println("C" + pq.remove().idx);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of cars: ");
        int n = in.nextInt();
        int cars[][] = new int[n][2];
        System.out.println("Enter distance from origin (x,y): ");
        for(int i=0; i<n; i++){
            cars[i][0] = in.nextInt();
            cars[i][1] = in.nextInt();
        }
        System.out.print("Enter k to find k nearby cars: ");
        int k = in.nextInt();
        nearbyCars(cars, k);
        in.close();
    }
}