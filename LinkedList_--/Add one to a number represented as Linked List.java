import java.util.* ;
import java.awt.HeadlessException;
import java.io.*; 
/*************************************************************

Following is the class structure of the Node class:

    class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

*************************************************************/

public class Solution {
	public static int add(Node head){
		if(head==null) return 1;
		int carry=add(head.next);
		head.data+=carry;
		if(head.data<10) return 0;
		head.data=0;
		return 1;
	}
	public static Node addOne(Node head) {
		// Write your code here.
		int carry=add(head);
		if(carry==1){
			Node nn=new Node(1);
			nn.next=head;
			return nn;
		}
		return head;
	}
}
