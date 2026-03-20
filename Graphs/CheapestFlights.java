import java.util.*;
public class CheapestFlights{
    public static class Flight{
        int src;
        int dest;
        int price;
        Flight(int src, int dest, int price){
            this.src = src;
            this.dest = dest;
            this.price = price;
        }
    }

    public static class Info {
        int n;
        int cost;
        int stops;
        Info(int n, int cost, int stops){
            this.n = n;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapest(ArrayList<Flight>[] flights, int src, int dest, int k) {
        int dist[] = new int[flights.length];
        for(int i=0; i<dist.length; i++){
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        }
        
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops > k)
                break;

            for(int i=0; i<flights[curr.n].size(); i++){
                Flight f = flights[curr.n].get(i);
                int v = f.dest;
                int wt = f.price;
                
                if(curr.cost + wt < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
            
        }
        if(dist[dest] == Integer.MAX_VALUE)
            return -1;
        else
            return dist[dest];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of aiports: ");
        int n = in.nextInt();
        System.out.print("Enter no. of flights: ");
        int f = in.nextInt();

        ArrayList<Flight>[] flights = new ArrayList[n];
        for(int i=0; i<n; i++)
            flights[i] = new ArrayList<>();

        System.out.println("Enter the flight details (src, dest, price): ");
        for(int i=0; i<f; i++){
            int src = in.nextInt();
            int dest = in.nextInt();
            int price = in.nextInt();
            flights[src].add(new Flight(src, dest, price));
        }

        System.out.print("Enter the source airport: ");
        int src = in.nextInt();
        System.out.print("Enter the destination airport: ");
        int dest = in.nextInt();
        System.out.print("Enter the no. of preferred stops: ");
        int k = in.nextInt();

        int minCost = cheapest(flights, src, dest, k);
        System.out.println("Cheapest flights within preferred stops: " + minCost);
        in.close();
    }
}