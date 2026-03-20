import java.util.*;
public class BFStraversal{
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

    public static void bfs(ArrayList<Edge>[] graph, int src) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        
        q.add(src);
        while(! q.isEmpty()){
            int curr = q.remove();
            if(! visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                    Edge edge = graph[curr].get(i);
                    q.add(edge.dest);
                }
            }
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

        System.out.print("BFS Traversal: ");
        bfs(graph, src);
        in.close();
    }
}