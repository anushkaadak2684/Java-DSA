import java.util.*;
public class StackOperations {
    public static class Stack {
        ArrayList <Integer> list = new ArrayList<>();

        boolean isEmpty(){
            if(list.size() == 0)
                return true;
            return false;
        }
        void push(int data){
            list.add(data);
        }
        int pop(){
            if(isEmpty())
                return -1;
            int val = list.get(list.size()-1);
            list.remove(list.size()-1);
            return val;
        }
        int peek(){
            if(isEmpty())
                return -1;
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack s = new Stack();
        System.out.println("Enter 5 elements: ");
        for(int i=0; i<5; i++){
            int n = in.nextInt();
            s.push(n);
        }
        System.out.println("Element to be deleted: " + s.pop());
        System.out.println("Topmost element: " + s.peek());
        System.out.println("Current stack: ");
        while(! s.isEmpty()){
            System.out.println(s.pop());
        }
        in.close();
    }
}
