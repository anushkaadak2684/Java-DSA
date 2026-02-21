import java.util.*;
public class PairSumII{
    public static boolean findTarget(ArrayList<Integer> list, int target){
        int lp = -1, rp = -1;
        int n = list.size();
        for(int i=0; i<n; i++){
            if(list.get(i) > list.get(i+1)){
                lp = i+1;
                rp = i;
                break;
            }
        }
        while(lp != rp){
            if(list.get(lp) + list.get(rp) == target)
                return true;
            else if(list.get(lp) + list.get(rp) < target)
                lp = (lp+1) % n;
            else
                rp = (n + rp-1) % n;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter a sorted and rotated list of 5 digits: ");
        for(int i=0; i<5; i++){
            int val = in.nextInt();
            list.add(val);
        }
        System.out.print("Enter the target sum: ");
        int target = in.nextInt();
        if(findTarget(list, target))
            System.out.println("Target found!");
        else
            System.out.println("Target not found!");
        in.close();
    }
}