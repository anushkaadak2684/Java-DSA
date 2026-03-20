import java.util.*;
public class TopSortBFS {
    public static class Edge {
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void indegree(ArrayList<Edge>[] graph, int indegree[]) {
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        int indegree[] = new int[graph.length];
        indegree(graph, indegree);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        System.out.print("Topological Sort: ");
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;

                if(indegree[e.dest] == 0)
                    q.add(e.dest);
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
