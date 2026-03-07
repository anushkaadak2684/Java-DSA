import java.util.*;
public class JobSequencing {
    public static void sequence(int arr[][]) {
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[2]));
        int time = 0, maxProfit = 0;
        ArrayList <Integer> sequence = new ArrayList<>();
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i][1] > time){
                time++;
                sequence.add(arr[i][0]);
                maxProfit += arr[i][2];
            }
        }
        System.out.print("The Job Sequence is: ");
        for(int i=0; i<sequence.size(); i++)
            System.out.print(sequence.get(i) + " ");
        System.out.println("\nMaximum Profit: " + maxProfit);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of jobs: ");
        int n = in.nextInt();
        int arr[][] = new int[n][3];
        System.out.println("Enter the deadline and profit for each job: ");
        for(int i=0; i<n; i++){
            arr[i][0] = i;
            for(int j=1; j<3; j++){
                arr[i][j]=in.nextInt();
            }
        }
        sequence(arr);
        in.close();
    }
}

