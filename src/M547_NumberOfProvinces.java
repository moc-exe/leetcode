/* MEDIUM 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.HashMap;

public class M547_NumberOfProvinces {
    
    public int findCircleNum(int[][] isConnected) {
        
        HashMap<Integer, Integer> terrMap = new HashMap<>();
        int traversalCounter = 0;
        for (int i = 0; i < isConnected.length; i++) {
            terrMap.put(i, -1);
        }
        // so -1 means it wasnt visited in DFS

        while(terrMap.values().contains(-1)){ // some nodes were not visited
            traversalCounter++;
            int startNode = getFirstKeyForVal(terrMap, -1);
            DFS(isConnected, terrMap, traversalCounter, startNode);
        }
        return traversalCounter;

    }

    public void DFS(int[][] isConnected, HashMap<Integer, Integer> terrMap, int traversalCounter, int currNode){

        terrMap.put(currNode, traversalCounter); // mark as visited with the turn
        for (int i = 0; i < isConnected[currNode].length; i++) {
            
            if(isConnected[currNode][i] != 0 && terrMap.get(i) == -1){
                DFS(isConnected, terrMap, traversalCounter, i);
            }
        }
    }
    public int getFirstKeyForVal(HashMap<Integer, Integer> map, int val){

        for (var entry : map.entrySet()) {
            if (entry.getValue().equals(val)) {
                return entry.getKey();
            }
        }
        return -1; // Return null if not found
    }
}
