import java.util.*;
public class ArticulationPoint {
    public static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static int time = 0;

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int disc[], int low[], boolean vis[], boolean ap[]){
        vis[curr] = true;
        disc[curr] = low[curr] = ++time;
        int children = 0;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(e.dest == par)
                continue;
            if(vis[e.dest])
                low[curr] = Math.min(low[curr], disc[e.dest]);
            else{
                dfs(graph, e.dest, curr, disc, low, vis, ap);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(par !=-1 && low[e.dest] >= disc[curr])
                    ap[curr] = true;
                children++;
            }
        }

        if(par == -1 && children > 1)
            ap[curr] = true;
    }

    public static void findAP(ArrayList<Edge>[] graph) {
        int disc[] = new int[graph.length];
        int low[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        boolean ap[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i])
                dfs(graph, i, -1, disc, low, vis, ap);
        }

        for(int i=0; i<graph.length; i++){
            if(ap[i] == true)
                System.out.print(i + " ");
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
            graph[dest].add(new Edge(dest, src));
        }

        System.out.print("Articulation Points in Graph: ");
        findAP(graph);
        in.close();
    }
} 

