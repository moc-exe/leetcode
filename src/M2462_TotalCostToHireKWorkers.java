/*
 * MEDIUM - 2462. Total Cost to Hire K Workers
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class M2462_TotalCostToHireKWorkers {
    
    public static long totalCost(int[] costs, int k, int candidates) {
        
        long totalCost = 0;
        int numChosen = 0;

        if(costs.length < candidates * 2){
            // then jus 1 min_heap

            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i = 0; i < costs.length; i++) {
                
                q.add(costs[i]);
            }
            for (int i = 0; i < k; i++) {
                totalCost += q.poll();
            }

            return totalCost;
        }
        else{
            
            // then let's keep 2 minheaps
            PriorityQueue<Integer> front = new PriorityQueue<>();
            PriorityQueue<Integer> rear = new PriorityQueue<>();
            Deque<Integer> mainQ = new LinkedList<>();
            
            for (int i = 0; i < costs.length; i++) {
                mainQ.add(costs[i]);
            }

            for (int i = 0; i < candidates; i++) {
                
                front.add(mainQ.pollFirst());
                rear.add(mainQ.pollLast());
            }

            while(numChosen < k && !mainQ.isEmpty()){

                if(front.peek() <= rear.peek()){

                    totalCost += front.poll();
                    front.add(mainQ.pollFirst());
                }
                else{

                    totalCost += rear.poll();
                    rear.add(mainQ.pollLast()); 
                }
                numChosen++;
            }
            if(numChosen == k){return totalCost;}
            while(!rear.isEmpty()){

                front.add(rear.poll());
            }
            while(numChosen < k){

                totalCost += front.poll();
                numChosen++;
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        
        int[] costs = new int[]{17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;

        System.out.println(totalCost(costs, k, candidates));

    }
}
