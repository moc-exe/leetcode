import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Router {


    private final int memoryLimit;
    private Queue<String> queue;
    private HashMap<String, int[]> map;
    private ArrayList<Integer> timestamps;
    
    public Router(int memoryLimit) {

        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.map = new HashMap<>();
        this.timestamps = new ArrayList<>();
    
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {

        String newPacketHash = Integer.toString(source) + ":" + Integer.toString(destination) + ":" + Integer.toString(timestamp);

        if(map.containsKey(newPacketHash)){return false;}
        if(queue.size() >= memoryLimit){
            String packetHash = queue.poll();
            map.remove(packetHash);
            // oldest needs to be removed
        }
        queue.add(newPacketHash);
        map.put(newPacketHash, new int[]{source, destination, timestamp});
        return true;
    }
    
    public int[] forwardPacket(){

        if(queue.isEmpty()){return new int[0];}
        String elementHash = queue.poll();
        return map.remove(elementHash);
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        
        int count = 0;

        for(var packet : map.values()){
            int packetDestination = packet[1];
            int packetTimestamp = packet[2];
            if(packetTimestamp >= startTime && packetTimestamp <= endTime && packetDestination == destination){
                count++;
            }
        }

        return count;

    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */