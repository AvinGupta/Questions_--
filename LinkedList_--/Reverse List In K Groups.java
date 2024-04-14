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
    public static Node reverse(Node head){
        if(head==null || head.next==null) return head;
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public static Node findNode(Node temp,int k){
        k--;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public static Node kReverse(Node head, int k) {
        // Write your code here.
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            Node kthNode=findNode(temp,k);
            if(kthNode==null){
                if(prev!=null) prev.next=temp;
                break;
            }
            Node next=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head){
                head=kthNode;
            }
            else{
                prev.next=kthNode;
            }
            prev=temp;
            temp=next;
        }
        return head;
    }
}
