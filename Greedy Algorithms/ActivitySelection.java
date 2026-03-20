import java.util.*;
public class ActivitySelection {
    public static void activitySelection(int start[], int end[]){
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
                activities[i][0] = i;
                activities[i][1] = start[i];
                activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList <Integer> act = new ArrayList<>();
        maxAct++;
        act.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1; i<start.length; i++){
            if(activities[i][1] >= lastEnd){
                maxAct++;
                act.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Maximum number of activities: " + maxAct);
        System.out.print("The activities are: ");
        for(int i=0; i<act.size(); i++)
            System.out.print("A" + act.get(i) + " ");
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of activities: ");
        int n = in.nextInt();
        int start[] = new int[n];
        int end[] = new int[n];
        System.out.print("Enter the start time of each activity: ");
        for(int i=0; i<start.length; i++)
            start[i]=in.nextInt();
        System.out.print("Enter the end time of each activity: ");
        for(int i=0; i<end.length; i++)
            end[i]=in.nextInt();
        activitySelection(start, end);
        in.close();
    }
}