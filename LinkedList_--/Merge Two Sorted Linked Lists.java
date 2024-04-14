import java.io.*;
import java.util.* ;

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		// Write your code here.
        LinkedListNode<Integer> ln=new LinkedListNode<>(-1);
        LinkedListNode<Integer> temp=ln;
        while(first!=null && second!= null){
            if(first.data<second.data){
                temp.next=first;
                temp=temp.next;
                first=first.next;
            }
            else{
                temp.next=second;
                temp=temp.next;
                second=second.next;
            }
        }
        if(first==null) temp.next=second;
        if(second==null) temp.next=first;
        return ln.next;
	}
}
