import java.util.*;
public class Bellman{
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

    public static void bellman(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<graph.length-1; i++){
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
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
        bellman(graph, src);
        in.close();
    }
}
