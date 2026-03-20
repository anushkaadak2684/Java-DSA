import java.util.*;
public class Kruskal {
    public static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int weight;
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

    public static int v;
    public static int par[];
    public static int rank[];

    public static void init(){
        for(int i=0; i<v; i++){
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x){
        if(x == par[x])
            return x;
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if(rank[parA] < rank[parB])
            par[parA] = parB;
        else if(rank[parA] > rank[parB])
            par[parB] = parA;
        else{
            par[parB] = parA;
            rank[parA]++;
        }
    }

    public static void kruskal(ArrayList<Edge> edges){
        Collections.sort(edges);
        int count=0;
        int finalCost=0;

        for(int i=0; count<v-1; i++){
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
            if(parA != parB){
                finalCost += e.weight;
                union(e.src, e.dest);
                count++;
            }
        }
        System.out.println("Minimum cost of MST: " + finalCost);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of vertices: ");
        v = in.nextInt();

        par = new int[v];
        rank = new int[v];
        init();

        System.out.print("Enter no. of edges: ");
        int e = in.nextInt();
        ArrayList<Edge> edges = new ArrayList<>();
        
        System.out.println("Enter the edges (src, dest, weight): ");
        for(int i=0; i<e; i++){
            int src = in.nextInt();
            int dest = in.nextInt();
            int weight = in.nextInt();
            edges.add(new Edge(src, dest, weight));
        }
        kruskal(edges);
        in.close();
    }
}
    