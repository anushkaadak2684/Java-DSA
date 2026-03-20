import java.util.*;
public class ConnectingCities{
    public static class Edge{
        int src;
        int dest;
        int weight;
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int v;
        int cost;
        Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        } 
        @Override
        public int compareTo(Pair p){
            return this.cost - p.cost;
        }
    }

    public static void connectingCities(ArrayList<Edge>[] graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        boolean visited[] = new boolean[graph.length];

        int finalCost=0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.v]){
                visited[curr.v] = true;
                finalCost += curr.cost;
                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    if(e.weight != 0)
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        System.out.println("Minimum cost of connecting all cities: " + finalCost);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of cities: ");
        int c = in.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[c];
        for(int i=0; i<c; i++)
            graph[i] = new ArrayList<>();

        System.out.println("Enter the distance from each city to all cities: ");
        for(int i=0; i<c; i++){
            for(int j=0; j<c; j++){
                int dist = in.nextInt();
                graph[i].add(new Edge(i, j, dist));
                graph[j].add(new Edge(j, i, dist));
            }
        }
        connectingCities(graph);
        in.close();
    }
}
