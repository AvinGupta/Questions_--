/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node reverseDLL(Node head)
    {
        // Write your code here.
        if(head==null || head.next==null) return head;
        Node curr=head;
        Node last=null;
        while(curr!=null){
            last=curr.prev;
            curr.prev=curr.next;
            curr.next=last;
            curr=curr.prev;
        }
        return last.prev;
    }
}
