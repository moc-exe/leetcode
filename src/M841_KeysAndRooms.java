/*
 * MEDIUM 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M841_KeysAndRooms {
    
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int totalRooms = rooms.size();
        int visitedCounter = 0;
        HashSet<Integer> totalKeySet = new HashSet<>();
        Queue<Integer> newRoomsToVisit = new LinkedList<>();
        totalKeySet.add(0);
        visitedCounter++;

        // let's visit the first room to start the process
        for(var room_key : rooms.get(0)){

            if(totalKeySet.contains(room_key)){
                continue;
            }
            else{
                newRoomsToVisit.add(room_key);
                totalKeySet.add(room_key);
            }
        }
        

        while(visitedCounter != totalRooms && !newRoomsToVisit.isEmpty()){

            var currRoomToVisit = newRoomsToVisit.poll();
            var keysFromRoomToVisit = rooms.get(currRoomToVisit);
            visitedCounter++;

            for(var room_key : keysFromRoomToVisit){

                if(totalKeySet.contains(room_key)){
                    continue;
                }
                else{
                    newRoomsToVisit.add(room_key);
                    totalKeySet.add(room_key);
                }
            }
        }

        return visitedCounter == totalRooms ? true : false;
    }

    public static void main(String[] args) {
        
        List<List<Integer>> rooms = List.of(
            List.of(1,3),
            List.of(3,0,1),
            List.of(2),
            List.of(0)
        );

        System.out.println(canVisitAllRooms(rooms));

    }
}
