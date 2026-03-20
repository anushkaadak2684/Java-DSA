import java.util.*;
public class HasPath{
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

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]) {
        if(src == dest)
            return true;

        visited[src] = true;

        for(int i=0; i<graph[src].size(); i++){
            Edge edge = graph[src].get(i);
            if(!visited[edge.dest] && hasPath(graph, edge.dest, dest, visited))
                return true;
        }
        return false;
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
        System.out.print("Enter the destination node: ");
        int dest = in.nextInt();

        boolean visited[] = new boolean[graph.length];

        boolean result = hasPath(graph, src, dest, visited);
        if(result == true)
            System.out.println("Path exists...");
        else
            System.out.println("Path does not exist");
        in.close();
    }
}
