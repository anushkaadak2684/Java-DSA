import java.util.*;
public class Bipartite {
    public static class Edge {
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        int color[] = new int[graph.length];
        for(int i=0; i<color.length; i++)
            color[i] = -1;

        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;
                while ((! q.isEmpty())) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++){
                        Edge edge = graph[curr].get(j);
                        if(color[edge.dest] == -1){
                            q.add(edge.dest);
                            int newColor = color[curr] == 0 ? 1 : 0;
                            color[edge.dest] = newColor;
                        }
                        else if(color[edge.dest] == color[curr])
                            return false;
                    }
                }
            }
        }
        return true;
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
            graph[dest].add(new Edge(dest, src));
        }

        if(isBipartite(graph))
            System.out.println("Bipartite Graph");
        else
            System.out.println("NOT a Bipartite Graph");
        in.close();
    }
}
