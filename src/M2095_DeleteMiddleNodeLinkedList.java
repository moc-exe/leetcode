/* MEDIUM - 2095. Delete the Middle Node of a Linked List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

public class M2095_DeleteMiddleNodeLinkedList {
    
    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    };

    public ListNode deleteMiddle(ListNode head) {
        
        int len = 0;
        ListNode currFirstPass = head;
        
        while(currFirstPass != null){
            currFirstPass = currFirstPass.next;
            len++;
        }

        int mid = (int) Math.floor( len / 2);

        if(mid == 0){
            // then head
            return head.next;

        }
        else if(mid == len - 1){
            // then tail
            
            ListNode curr = head; 
            int counter = 0;
            while(counter < len - 2){
                curr = curr.next;
                counter++;
            }
            curr.next = null;
            return head;

        }
        else{
            // then true mid

            ListNode front = head;
            ListNode rear = null;
            int counter = 0;

            while(counter < mid - 1){
                front = front.next;
                counter++;
            }

            
            rear = front.next.next;
            ListNode deleted = front.next;
            deleted.next = null;
            front.next = rear;
            return head;
        }

    };

};

