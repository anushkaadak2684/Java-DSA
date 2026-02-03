public class BuyandSellstocks{
    public static int maxProfit(int prices[]){
        int buyprice = prices[0], maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            if(buyprice < prices[i]){
                int profit = prices[i] - buyprice;
                maxProfit = Math.max(maxProfit, profit);
            }
            else
                buyprice = prices[i];
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println("Maximum profit: " + maxProfit(prices));
    }
}
