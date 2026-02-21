import java.util.*;
public class PairSumI{
    public static boolean findTarget(ArrayList<Integer> list, int target){
        int lp = 0, rp = list.size()-1;
        while(lp != rp){
            if(list.get(lp) + list.get(rp) == target)
                return true;
            else if(list.get(lp) + list.get(rp) < target)
                lp++;
            else
                rp--;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter a sorted list of 5 digits: ");
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