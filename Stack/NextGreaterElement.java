import java.util.*;
public class NextGreaterElement {
    public static void nextGreaterElement(int arr[]){
        int nextGreater[] = new int[arr.length];
        Stack <Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && s.peek() <= arr[i]){
                s.pop();
            }
            if(s.isEmpty())
                nextGreater[i] = -1;
            else
                nextGreater[i] = s.peek();
            s.push(arr[i]);
        }
        System.out.print("Next greater element for each element: ");
        for(int i=0; i<nextGreater.length; i++)
            System.out.print(nextGreater[i] + " ");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.print("Enter the elements: ");
        for(int i=0; i<5; i++)
            arr[i] = in.nextInt();
        nextGreaterElement(arr);
        in.close();
    }
}

