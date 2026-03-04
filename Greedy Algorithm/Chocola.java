import java.util.*;
public class Chocola {
    public static void minCost(Integer horizontal[], Integer vertical[]){
        Arrays.sort(horizontal, Collections.reverseOrder());
        Arrays.sort(vertical, Collections.reverseOrder());

        int h=0, v=0, hp=1, vp=1, cost=0;
        while(h < horizontal.length && v < vertical.length){
            if(horizontal[h] >= vertical[v]){
                cost += horizontal[h]*vp;
                hp++; h++;
            }
            else{
                cost += vertical[v]*hp;
                vp++; v++;
            }
        }
        while(h < horizontal.length){
                cost += horizontal[h]*vp;
                hp++; h++;
        }
        while(v < vertical.length){
                cost += vertical[v]*hp;
                vp++; v++;
        }
        System.out.println("Minimum cost of breaking the whole chocolate: " + cost);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the chocolate bar (m x n): ");
        int m = in.nextInt();
        int n = in.nextInt();
        Integer horizontal[] = new Integer[n-1];
        Integer vertical[] = new Integer[m-1];
        System.out.print("Enter the cost of vertical cuts (m - 1): ");
        for(int i=0; i<vertical.length; i++)
            vertical[i]=in.nextInt();
        System.out.print("Enter the cost of horizontal cuts (n - 1): ");
        for(int i=0; i<horizontal.length; i++)
            horizontal[i]=in.nextInt();
        minCost(horizontal, vertical); 
        in.close(); 
    }
}
