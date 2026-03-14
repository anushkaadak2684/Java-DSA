import java.util.*;
public class ConnectRopes {
    public static void minCost(int length[]){
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for(int i=0; i<length.length; i++)
            pq.add(length[i]);

        int cost=0;
        while(pq.size() > 1){
            int n1 = pq.remove();
            int n2 = pq.remove();
            cost += n1 + n2;
            pq.add(n1 + n2);
        }
        System.out.print("Minimum cost of connecting n ropes: " + cost);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of ropes: ");
        int n = in.nextInt();
        int length[] = new int[n];
        System.out.print("Enter length of each rope: ");
        for(int i=0; i<n; i++)
            length[i] = in.nextInt();
        minCost(length);
        in.close();
    }
}
