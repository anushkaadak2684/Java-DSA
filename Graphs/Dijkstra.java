import java.util.*;
public class Dijkstra{
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
        int n;
        int path;
        Pair(int n, int path){
            this.n = n;
            this.path = path;
        } 
        @Override
        public int compareTo(Pair p){
            return this.path - p.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        boolean visited[] = new boolean[graph.length];

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.n]){
                visited[curr.n] = true;
                for(int i=0; i<graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    int u = curr.n;
                    int v = e.dest;
                    int wt = e.weight;
                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++){
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of vertices: ");
        int v = in.nextInt();
        System.out.print("Enter no. of edges: ");
        int e = in.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<v; i++)
            graph[i] = new ArrayList<>();

        System.out.println("Enter the edges (src, dest, weight): ");
        for(int i=0; i<e; i++){
            int src = in.nextInt();
            int dest = in.nextInt();
            int weight = in.nextInt();
            graph[src].add(new Edge(src, dest, weight));
        }

        System.out.print("Enter the source node: ");
        int src = in.nextInt();

        System.out.println("Shortest Path from source to all nodes: ");
        dijkstra(graph, src);
        in.close();
    }
}