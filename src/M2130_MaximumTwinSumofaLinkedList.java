/*
 * 
 * MEDIUM 2130. Maximum Twin Sum of a Linked List
https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.HashMap;

public class M2130_MaximumTwinSumofaLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int pairSum(ListNode head) {
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode curr = head;
        int nodeIndex = 0;

        // traverse once to map all the values then we'll use a hashmap O(1) loopkup and 
        // neatly traverse it once as well for a final O(N) complexity of this algo
        while(curr != null){

            map.put(nodeIndex, curr.val);    
            nodeIndex++;
            curr = curr.next;
        
        }

        int len = nodeIndex;
        int currMax = Integer.MIN_VALUE;
        
        for (int i = 0; i <= len / 2 - 1; i++) {
            
            if(map.containsKey(i) && map.containsKey(len - 1 - i)){

                int left = map.get(i);
                int right = map.get(len - 1 - i);
                currMax = currMax < (left + right) ? left + right : currMax;
            }

        }

        return currMax;

    }

}
