import java.util.*;
public class QueueInterleave {
    public static void interleave(Queue <Integer> q1){
        if(q1.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int size = q1.size()/2;
        Queue <Integer> q2 = new LinkedList<>();
        for(int i=0; i<size; i++)
            q2.add(q1.remove());
        while(!q2.isEmpty()){
            q1.add(q2.remove());
            q1.add(q1.remove());
        }
    }
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Queue <Integer> q1 = new LinkedList<>();
    System.out.print("Enter 10 numbers in a queue: ");
    for(int i=0; i<10; i++){
        int n = in.nextInt();
        q1.add(n);
    }
    System.out.print("Interleave Queue: ");
    interleave(q1);
    while(!q1.isEmpty()){
        System.out.print(q1.remove() + " ");
    }
    in.close();
    } 
}
    
