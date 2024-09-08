class Solution{
    Node removeDuplicates(Node head){
        // Code Here.
        if(head==null || head.next==null) return head;
        Node curr=head.next;
        while(curr!=null){
            if(curr.data==curr.prev.data){
                curr.prev.next=curr.next;
                if(curr.next!=null){
                    curr.next.prev=curr.prev;
                }
            }
            curr=curr.next;
        }
        return head;
    }
}
