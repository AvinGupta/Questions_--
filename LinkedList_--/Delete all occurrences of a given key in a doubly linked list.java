class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node dummy=new Node();
        Node temp=dummy;
        while(head!=null){
            if(head.data!=x){
                if(temp==dummy){
                    temp.next=head;
                    head.prev=null;
                }
                else{
                    head.prev=temp;
                    temp.next=head;
                }
                temp=temp.next;
            }
            head=head.next;
        }
        temp.next=null;
        return dummy.next;
    }
}
