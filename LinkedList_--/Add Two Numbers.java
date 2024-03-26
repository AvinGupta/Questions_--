import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.
        LinkedListNode dummy=new LinkedListNode(-1);
        LinkedListNode curr=dummy;
        LinkedListNode t1=head1;
        LinkedListNode t2=head2;
        int carry=0;
        while(t1!=null || t2!=null){
                int sum=carry;
                if(t1!=null) sum+=t1.data;
                if(t2!=null) sum+=t2.data;
                LinkedListNode nn=new LinkedListNode(sum%10); 
                carry=sum/10;
                curr.next=nn;
                curr=curr.next;

                if(t1!=null) t1=t1.next;
                if(t2!=null) t2=t2.next;
        }
        if(carry!=0){
            LinkedListNode nn=new LinkedListNode(carry);
            curr.next=nn;
        }
        return dummy.next;
    }
}
