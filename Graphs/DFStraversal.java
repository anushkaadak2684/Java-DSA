import java.util.*;
public class DFStraversal{
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

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
            if(!visited[edge.dest])
                dfs(graph, edge.dest, visited);
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
            graph[dest].add(new Edge(dest, src, weight));
        }

        System.out.print("Enter the source node: ");
        int src = in.nextInt();

        boolean visited[] = new boolean[graph.length];

        System.out.print("DFS Traversal: ");
        dfs(graph, src, visited);
        in.close();
    }
}
