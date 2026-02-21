import java.util.*;
public class TwoPointerMWC {
    public static int maxwater(ArrayList<Integer> height){
        int maxwater = 0, lp = 0, rp = height.size()-1;
        while(lp < rp){
            int h = Math.min(height.get(lp), height.get(rp));
            int currwater = h * (rp - lp);
            maxwater = Math.max(maxwater, currwater);
            if(lp < rp)
                lp++;
            else
                rp--;
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
