/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

*/
public static Node reverseDLL(Node  head)
{
    //Your code here
    if(head==null || head.next==null) return head;
    Node last=null;
    Node curr=head;
    while(curr!=null){
        //storing the prev node in last
        last=curr.prev;
        //pointint the previous link to next.
        curr.prev=curr.next;
        //pointing the next link to prev
        curr.next=last;
        //moving forward to the  next node 
        curr=curr.prev;
    }
    //return the last node as the head.
    return last.prev;
}
