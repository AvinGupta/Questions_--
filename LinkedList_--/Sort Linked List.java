

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

public class Solution {
    public static Node mergeTwoList(Node list1,Node list2){
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                temp.next=list1;
                temp=temp.next;
                list1=list1.next;
            }
            else{
                temp.next=list2;
                temp=temp.next;
                list2=list2.next;
            }
        }
        if(list1==null) temp.next=list2;
        if(list2==null) temp.next=list1;
        return dummy.next; 
    }
    public static Node findMiddle(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node sortList(Node head) {
        //Write your code here
        if(head==null || head.next==null) return head;
        Node middle=findMiddle(head);
        Node head2=middle.next;
        middle.next=null;
        Node list1=sortList(head);
        Node list2=sortList(head2);
        return mergeTwoList(list1, list2);
    }
}
