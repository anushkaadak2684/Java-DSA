import java.util.*;
public class MostWaterContainer {
    public static int maxwater(ArrayList<Integer> height){
        int maxwater = 0;
        for(int i=0; i<height.size(); i++){
            for(int j=i+1; j<height.size(); j++){
                int h = Math.min(height.get(i), height.get(j));
                int currwater = h * (j-i);
                maxwater = Math.max(maxwater, currwater);
            }
        }
        return maxwater;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> height = new ArrayList<>();
        System.out.print("Enter total number of containers: ");
        int n = in.nextInt();
        System.out.println("Enter the heights of the containers:");
        for(int i=0; i<n; i++){
            int val = in.nextInt();
            height.add(val);
        }
        System.out.print("Most amount of water can be held: "+ maxwater(height));
        in.close();
    }
}
