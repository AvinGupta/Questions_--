/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node random;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.random = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.random = null;
     }
     Node(int data, Node next, Node random)
     {
         this.data = data;
         this.next = next;
         this.random = random;
     }
 }

 *****************************************************************/

public class Solution {
    public static void insertNode(Node head){
        Node temp=head;
        while(temp!=null){
            Node nn=new Node(temp.data);
            nn.next=temp.next;
            temp.next=nn;
            temp=temp.next.next;
        }
    }
    public static void copyRandom(Node head){
        Node temp=head;
        while(temp!=null){
            Node nn=temp.next;
            if(temp.random!=null){
                nn.random=temp.random.next;
            }
            else{
                nn.random=null;
            }
            temp=temp.next.next;
        }
    }
    public static Node seperate(Node head){
        Node temp=head;
        Node dummy=new Node(-1);
        Node res=dummy;
        while(temp!=null){
            res.next=temp.next;
            res=res.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummy.next;
    }
    public static Node cloneLL(Node head) {
        // Write your code here.
        insertNode(head);
        copyRandom(head);
        return seperate(head);
    }
}
