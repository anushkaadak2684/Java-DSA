import java.util.*;
public class IndianCoins {
    public static void change(int val) {
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        Arrays.sort(coins);
        int count = 0;
        ArrayList <Integer> money = new ArrayList<>();
        for(int i=coins.length-1; i>=0; i--){
            if(coins[i] <= val){
                while(coins[i] <= val){
                    count++;
                    money.add(coins[i]);
                    val -= coins[i];
                }
            }
        }
        System.out.println("Minimum number of coins: " + count);
        System.out.print("The coins are: ");
        for(int i=0; i<money.size(); i++)
            System.out.print(money.get(i) + " ");
    }
   public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the value: ");
        int val = in.nextInt();
        change(val);
        in.close();
    } 
}
