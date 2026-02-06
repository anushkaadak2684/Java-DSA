public class ShortestPath {
    public static double shortestPath(String path){
        int x=0, y=0;
        for(int i=0; i<path.length(); i++){
            char dir = path.charAt(i);
            if(dir == 'N')
                y++;
            else if(dir == 'S')
                y--;
            if(dir == 'E')
                x++;
            else
                x--;
        }
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println("Shortest path: " + shortestPath(path));
    }
}
