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
 };

 *****************************************************************/

public class Solution {
    public static Node findNode(Node temp,int k){
        int cnt=1;
        while(temp!=null){
            if(cnt==k) return temp;
            cnt++;
            temp=temp.next; 
        }
        return temp;
    }
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if(head==null || head.next==null) return head;
        Node tail=head;
        int cnt=1;
        while(tail.next!=null){
            cnt++;
            tail=tail.next;
        }
        if(k%cnt==0) return head;
        k%=cnt;
        tail.next=head;
        Node kth=findNode(head,cnt-k);
        head=kth.next;
        kth.next=null;
        return head;
    }
}
