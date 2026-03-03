import java.util.*;
public class StockSpan {
    public static void stockSpan(int stocks[]){
        int span[] = new int[stocks.length];
        Stack <Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i=1; i<stocks.length; i++){
            while(!s.isEmpty() && stocks[s.peek()] < stocks[i]){
                s.pop();
            }
            if(s.isEmpty())
                span[i] = i + 1;
            else
                span[i] = i - s.peek();
            s.push(i);
        }
        System.out.println("Span for each stock:");
        System.out.println("Stock\tSpan");
        for(int i=0; i<span.length; i++)
            System.out.println(stocks[i] + "\t" + span[i]);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stocks[] = new int[7];
        System.out.print("Enter the stock prices: ");
        for(int i=0; i<7; i++)
            stocks[i] = in.nextInt();
        stockSpan(stocks);
        in.close();
    }
}
