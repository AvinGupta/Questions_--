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
    public static Node reverseLinkedList(Node head)
    {
        // Write your code here.

        //iterative tc-->O(n) sc-->O(1).
        // if(head==null || head.next==null) return head;
        // Node prev=null;
        // Node curr=head;
        // while(curr!=null){
        //     Node temp=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=temp;
        // }
        // return prev;

        //recursive tc-->O(n) sc-->(n).
        if(head==null || head.next==null) return head;
        Node newHead=reverseLinkedList(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}
