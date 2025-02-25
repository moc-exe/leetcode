public class M328_OddEvenLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {

        if(head == null){return head;}
        if(head.next == null){return head;}
        if(head.next.next == null){return head;}
        
        ListNode curr = head; 
        ListNode evenHead = null;
        boolean oddTurn = true;
        ListNode currEven = null; 
        ListNode currOdd = null;
        while(curr != null){

            if(oddTurn){

                if(currOdd == null){
                    currOdd = curr;
            
                }
                else{

                    currOdd.next = curr;
                    currOdd = curr;  
                }
            }
            else{

                if(currEven == null){

                    evenHead = curr; 
                    currEven = curr;

                }
                else{

                    currEven.next = curr; 
                    currEven = curr;

                }

            }

            curr = curr.next;
            oddTurn = !oddTurn;

        }

        currEven.next = null;
        currOdd.next = null;

        ListNode pass = head; 
        while(pass.next != null){
            pass = pass.next;
        }

        pass.next = evenHead;

        return head;
    }


    
}
