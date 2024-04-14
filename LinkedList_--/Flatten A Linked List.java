/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node child;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.child = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.child = null;
     }
     Node(int data, Node next, Node child)
     {
         this.data = data;
         this.next = next;
         this.child = child;
     }
 }

 *****************************************************************/

public class Solution {
    public static Node mergeTwoList(Node list1,Node list2){
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                temp.child=list1;
                temp=temp.child;
                list1=list1.child;
            }
            else{
                temp.child=list2;
                temp=temp.child;
                list2=list2.child;
            }
            temp.next=null;
        }
        if(list1==null) temp.child=list2;
        if(list2==null) temp.child=list1;
        return dummy.child; 
    }
    public static Node flattenLinkedList(Node head) {
        //Write your code here
        if(head==null || head.next==null) return head;
        Node mergeHead=flattenLinkedList(head.next);
        head= mergeTwoList(mergeHead, head);
        return head;
    }
}
