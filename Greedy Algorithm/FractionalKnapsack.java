import java.util.*;
public class FractionalKnapsack {
    public static void maxtotalValue(int value[], int weight[], int capacity){
        double ratio[][] = new double[value.length][2];
        for(int i=0; i<value.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double)weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        double totalVal = 0;
        for(int i=ratio.length-1; i>=0; i--){
            int idx = (int) ratio[i][0]; 
            if(capacity >= weight[idx]){
                capacity -= weight[idx];
                totalVal += value[idx];
            }
            else{
                totalVal += ratio[i][1]*capacity;
                break;
            }
        }
        System.out.println("Maximum total value: " + totalVal);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = in.nextInt();
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = in.nextInt();
        int value[] = new int[n];
        int weight[] = new int[n];
        System.out.print("Enter the value of each item: ");
        for(int i=0; i<value.length; i++)
            value[i]=in.nextInt();
        System.out.print("Enter the weight of each item: ");
        for(int i=0; i<weight.length; i++)
            weight[i]=in.nextInt();
        maxtotalValue(value, weight, capacity);
        in.close();
    }
}
