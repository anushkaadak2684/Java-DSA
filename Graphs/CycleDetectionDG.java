import java.util.*;
public class CycleDetectionDG{
    public static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], boolean stack[]) {
        visited[curr] = true;
        stack[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
            if(stack[edge.dest])
                return true;
            if(!visited[edge.dest] && detectCycleUtil(graph, edge.dest, visited, stack))
                return true;
        }
        stack[curr] = false;
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(detectCycleUtil(graph, i, visited, stack))
                    return true;
            }
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

        System.out.println("Enter the edges (src, dest): ");
        for(int i=0; i<e; i++){
            int src = in.nextInt();
            int dest = in.nextInt();
            graph[src].add(new Edge(src, dest));
        }

        if(detectCycle(graph))
            System.out.println("Cycle exists...");
        else
            System.out.println("Cycle does not exist");
        in.close();
    }
}

