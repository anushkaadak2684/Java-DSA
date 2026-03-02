import java.util.*;
public class PushatBottom {
    public static void pushatBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushatBottom(s, data);
        s.push(top);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack <Integer> s = new Stack <>();
        System.out.println("Enter 5 elements: ");
        for(int i=0; i<5; i++){
            int n = in.nextInt();
            s.push(n);
        }
        System.out.print("Enter the element to be pushed at bottom: ");
        int data = in.nextInt();
        pushatBottom(s, data);
        System.out.println("Current stack: ");
        while(! s.isEmpty()){
            System.out.println(s.pop());
        }
        in.close();
    }
}

