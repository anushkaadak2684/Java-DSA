import java.util.*;
public class Prims{
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

    public static void prims(ArrayList<Edge>[] graph) {
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
                    pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        System.out.println("Minimum cost of MST: " + finalCost);
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
            graph[dest].add(new Edge(dest, src, weight));
        }
        prims(graph);
        in.close();
    }
}
