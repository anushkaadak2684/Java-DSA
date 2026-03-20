import java.util.*;
public class TopSortDFS {
    public static class Edge {
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++){
            if(!visited[i])
                topSortUtil(graph, visited, s, i);
        }

        System.out.print("Topological Sort: ");
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, boolean visited[], Stack<Integer> s, int curr) {
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
            if(!visited[edge.dest])
                topSortUtil(graph, visited, s, edge.dest);
        }
        s.push(curr);
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
        topSort(graph);
        in.close();
    }
}
