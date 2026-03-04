import java.util.*;
public class StackusingDeque {
    public static class Stack {
        Deque <Integer> dq = new LinkedList<>();
        boolean isEmpty(){
            return dq.isEmpty();
        }
        void push(int data){
                dq.addLast(data);
        }
        int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return dq.removeLast();
        }
        int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return dq.getLast();
        }
    }
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       Stack s = new Stack();
       System.out.print("Enter 5 elements: ");
        for(int i=0; i<5; i++){
            int n = in.nextInt();
            s.push(n);
        }
        System.out.println("Topmost Element: " + s.peek());
        System.out.print("Current Stack: ");
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        in.close();
    }
}

