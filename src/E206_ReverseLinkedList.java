
/*
EASY 206. Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
*/

public class E206_ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        
        if(head == null){return head;}
        if(head.next == null){return head;}

        ListNode curr = head; 
        ListNode prev = null; 
        while(curr != null){

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        return prev;

    }
    
}
