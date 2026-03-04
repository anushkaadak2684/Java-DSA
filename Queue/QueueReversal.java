import java.util.*;
public class QueueReversal {
    public static void reversal(Queue <Integer> q){
        if(q.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        Stack <Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Queue <Integer> q = new LinkedList<>();
    System.out.print("Enter 5 numbers in a queue: ");
    for(int i=0; i<5; i++){
        int n = in.nextInt();
        q.add(n);
    }
    System.out.print("Reversal Queue: ");
    reversal(q);
    while(!q.isEmpty()){
        System.out.print(q.remove() + " ");
    }
    in.close();
    } 
}
