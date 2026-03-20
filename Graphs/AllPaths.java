import java.util.*;
public class AllPaths{
    public static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void printPaths(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if(src == dest){
            System.out.println(path + dest);
            return;
        }

        for(int i=0; i<graph[src].size(); i++){
            Edge edge = graph[src].get(i);
            printPaths(graph, edge.dest, dest, path + src);
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

        System.out.println("Enter the edges (src, dest): ");
        for(int i=0; i<e; i++){
            int src = in.nextInt();
            int dest = in.nextInt();
            graph[src].add(new Edge(src, dest));
        }

        System.out.print("Enter the source node: ");
        int src = in.nextInt();
        System.out.print("Enter the destination node: ");
        int dest = in.nextInt();

        printPaths(graph, src, dest, "");
        in.close();
    }
}

