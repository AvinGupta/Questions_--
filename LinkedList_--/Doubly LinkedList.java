class node{
    int data;
    node next;
    node back;
    node(int data,node next,node back){
        this.data=data;
        this.next=next;
        this.back=back;
    }
    node(int data){
        this.data=data;
        this.next=null;
        this.back=null;
    }
}
public class Main{
    public static void display(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<-->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static int length(node head){
        node temp=head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }
    public static boolean checkElement(node head,int val){
        node temp=head;
        while(temp!=null){
            if(temp.data==val) return true;
            temp=temp.next;
        }
        return false;
    }
    public static node convert(int[] arr){
        node head=new node(arr[0]);
        node mover=head;
        for(int i=1;i<arr.length;i++){
            node temp=new node(arr[i],null,mover);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6};
		//creating new node in the linkedlist.
        //node y=new node(arr[0],null);
		//System.out.println(y.data);
		
		//converting array into linkedlist.
		node head=convert(arr);
		
		//displaying the linkedlist. or traversal in the linkedlist.
		display(head);
		System.out.println(length(head));
		
		//check an element in the linkedlist.
		System.out.println(checkElement(head,7));
		System.out.println(checkElement(head,4));
		
		
		//deleting the head  of the linkedlist.
		//node temp=removeHead(head);
		//display(temp);
		
		//deleting the tail of the linkedlist.
		//node temp=removeTail(head);
		//display(temp);
		
		//deleting the kth element from the linkedlist.
		//node temp=removeK(head,6);
		//display(temp);
		
		//removing the node from the linkedlist.
		//removeNode(head.next);
		//display(head);
		
		//insertin the node at the head of the linkedlist.
		//node temp=insertHead(head,57);
		//display(temp);
		
		//inserting the node before the tail of the  linkedlist.
		//node temp=insertbeforeTail(head,78);
		//display(temp);
		
		//inserting the element before the kth  node of the linkedlist.
		//node temp=insertbeforeK(head,3,98);
		//display(temp);
		
		//inserting a new node in the  linkedlist.
		insertbeforeNode(head.next.next.next.next,78);
		display(head);
		
	}
	
	//all insertion and deletion on doubly linkedlist.
	//deletion.
	public static node removeHead(node head){
	    if(head==null || head.next==null) return null;
	    node temp=head;
	    temp=temp.next;
	    temp.back=null;
	    head.next=null;
	    return temp;
	}
	
	public static node removeTail(node head){
	    if(head==null || head.next==null) return null;
	    node temp=head;
	    while(temp.next!=null){
	        temp=temp.next;
	    }
	    node prev=temp.back;
	    temp.back=null;
	    prev.next=null;
	    return head;
	}
	
	public static node removeK(node head,int k){
	    if(head==null) return null;
	    node temp=head;
	    int cnt=0;
	    while(temp!=null){
	        cnt++;
	        if(cnt==k) break;
	        temp=temp.next;
	    }
	    node prev=temp.back;
	    node front=temp.next;
	    if(prev==null && front==null){
	        return null;
	    }
	    else if(prev==null){
	        return removeHead(head);
	    }
	    else if(front==null){
	        return removeTail(head);
	    }
	    prev.next=front;
	    front.back=prev;
	    
	    temp.next=null;
	    temp.back=null;
	    return head;
	}
	
	//this will never ask  to delete  the head of the linkedlist.
	public static void removeNode(node temp){
	    node prev=temp.back;
	    node front=temp.next;
	    
	    if(front==null){
	        prev.next=null;
	        temp.back=null;
	        return;
	    }
	    front.back=prev;
	    prev.next=front;
	    
	    temp.back=temp.next=null;
	    return;
	}
	
	
	//insertion.
	public static node insertHead(node head,int val){
	    node temp=new node(val,head,null);
	    head.back=temp;
	    return temp;
	}
	
	public static node insertbeforeTail(node head,int val){
	    if(head.next==null){
	        return insertHead(head,val);
	    }
	    node tail=head;
	    while(tail.next!=null){
	        tail=tail.next;
	    }
	    node prev=tail.back;
	    node nn=new node(val,tail,prev);
	    prev.next=nn;
	    tail.back=nn;
	    return head;
	}
	
	public static node insertbeforeK(node head,int k,int val){
	    if(k==1){
	        return insertHead(head,val);
	    }
	    node temp=head;
	    int cnt=0;
	    while(temp!=null){
	        cnt++;
	        if(cnt==k) break;
	        temp=temp.next;
	    }
	    node prev=temp.back;
	    node nn=new node(val,temp,prev);
	    prev.next=nn;
	    temp.back=nn;
	    return head;
	}
	
	public static void insertbeforeNode(node temp,int val){
	    node prev=temp.back;
	    node nn=new node(val,temp,prev);
	    prev.next=nn;
	    temp.back=nn;
	}
}
