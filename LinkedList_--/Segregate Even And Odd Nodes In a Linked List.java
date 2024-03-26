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

public class Solution
{
    public static Node segregateEvenOdd(Node head)
    {
        // Write Your Code Here.
        if(head==null || head.next==null) return head;
        Node odd=new Node(-1);
        Node even=new Node(-1);
        Node oddHead=odd;
        Node evenHead=even;
        Node temp=head;
        while(temp!=null){
            if(temp.data%2==0){
                even.next=temp;
                even=even.next;
            }
            else{
                odd.next=temp;
                odd=odd.next;
            }
            temp=temp.next;
        }
        even.next=oddHead.next;
        odd.next=null;
        return evenHead.next;
    }
}
