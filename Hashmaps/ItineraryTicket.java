import java.util.*;
public class ItineraryTicket {
    public static void findItinerary(HashMap <String, String> map){
        HashMap <String, String> revMap = new HashMap<>();
        String start = null;
        
        for(String key : map.keySet())
            revMap.put(map.get(key), key);

        for(String key : map.keySet()){
            if(!revMap.containsKey(key))
                start = key;
        }

        while(start != null) {
            System.out.print(" -> " + start);
            start = map.get(start);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HashMap <String, String> map = new HashMap<>();
        System.out.println("Enter routes (from -> to):");
        for(int i=0; i<5; i++){
            String from = in.next();
            String to = in.next();
            map.put(from, to);
        }
        findItinerary(map);
        in.close();
    }
}
