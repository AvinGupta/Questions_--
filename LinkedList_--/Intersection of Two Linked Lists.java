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
    public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here
        Node temp1=firstHead;
        Node temp2=secondHead;
        while(temp1!=temp2){
            if(temp1!=null) temp1=temp1.next;
            else temp1=secondHead;
            if(temp2!=null) temp2=temp2.next;
            else temp2=firstHead;
        }
        return temp1.data;
    }
}
