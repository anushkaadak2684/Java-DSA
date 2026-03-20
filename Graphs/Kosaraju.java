import java.util.*;
public class Kosaraju{
    public static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean visited[], Stack<Integer> s){
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
            if(!visited[edge.dest])
                topSort(graph, edge.dest, visited, s);
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] transpose, int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i=0; i<transpose[curr].size(); i++){
            Edge edge = transpose[curr].get(i);
            if(!visited[edge.dest])
                dfs(transpose, edge.dest, visited);
        }
    }

    public static void kosaraju(ArrayList<Edge>[] graph){
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visited[i])
                topSort(graph, i, visited, s);
        }

        ArrayList<Edge>[] transpose = new ArrayList[graph.length];
        for(int i=0; i<graph.length; i++){
            visited[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge edge = graph[i].get(j);
                transpose[edge.dest].add(new Edge(edge.dest, edge.src));
            }
        }

        while (!s.isEmpty()) {
            int curr = s.pop();
            if(!visited[curr]){
                dfs(transpose, curr, visited);
                System.out.println();
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

        System.out.println("Strongly Connected Components: ");
        kosaraju(graph);
        in.close();
    }
}

