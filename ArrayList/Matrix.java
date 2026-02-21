import java.util.ArrayList;
public class Matrix{
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i=1; i<=5; i++){
            list1.add(3*i);
            list2.add(4*i);
            list3.add(5*i);
        }
        mainlist.add(list1);
        mainlist.add(list2);
        mainlist.add(list3);

        for(int i=0; i<mainlist.size(); i++){
            ArrayList<Integer> currlist = mainlist.get(i);
            for(int j=0; j<currlist.size(); j++)
                System.out.print(currlist.get(j)+" ");
            System.out.println();
        }
    }
}