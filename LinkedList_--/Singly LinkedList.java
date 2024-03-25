class node{
    int data;
    node next;
    node(int data,node next){
        this.data=data;
        this.next=next;
    }
    node(int data){
        this.data=data;
        this.next=null;
    }
}
public class Main{
    public static void display(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
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
            node temp=new node(arr[i]);
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
		
		//removing the head from the linkedlist.
		//node temp=removeHead(head);
		//display(temp);
		
		//removing the tail from the linkedlist.
		//node temp=removeTail(head);
		//display(temp);
		
		//removing the element from the kth index in linkedlist.
		//node temp=removeK(head,5);
		//display(temp);
		
		// removing the element k from the linkedlist.
		//node temp=removeElement(head,7);
		//display(temp);
		
		//inserting element k at the head of the linkedlist.
		//node temp=insertHead(head,67);
		//display(temp);
		
		//inserting element k at the tail of the linkedlist.
		//node temp=insertTail(head,56);
		//display(temp);
		
		//inserting element val at the kth index of the linkedist.
		//node temp=insertK(head,45,3);
		//display(temp);
		
		//inserting element val before kth value of the element in the linkedlist.
		node temp=insertBeforeElement(head,34,5);
		display(temp);
	}
	
	//all insertion and deletion on singly linkedlist.
	//insertion
	public static node insertHead(node head,int val){
	   // node temp=new node(val,head);
	   // return temp;
	   return new node(val,head);
	}
	
	
	public static node insertTail(node head,int val){
	    if(head==null) return new node(val,head);
	    node temp=head;
	    while(temp.next!=null){
	        temp=temp.next;
	    }
	    node nn=new node(val);
	    temp.next=nn;
	    return head;
	}
	
	
	public static node insertK(node head,int val,int k){
	    if(head==null){
	        return new node(val,head);
	    }
	    if(k==1){
	        return new node(val,head);
	    }
	    node temp=head;
	    int cnt=0;
	    while(temp!=null){
	        cnt++;
	        if(cnt==k-1){
	            node nn=new node(val);
	            nn.next=temp.next;
	            temp.next=nn;
	            break;
	        }
	        temp=temp.next;
	    }
	    return head;
	}
	
	
	public static node insertBeforeElement(node head,int val,int k){
	    if(head==null){
	        return null;
	    }
	    if(head.data==k){
	        return new node(val,head);
	    }
	    node temp=head;
	    while(temp!=null){
	        if(temp.next.data==k){
	            node nn=new node(val);
	            nn.next=temp.next;
	            temp.next=nn;
	            break;
	        }
	        temp=temp.next;
	    }
	    return head;
	}
	
	
	//deletion
	public static node removeHead(node head){
	    if(head==null) return head;
	    head=head.next;
	    return head;
	}
	
	
	public static node removeTail(node head){
	    if(head==null || head.next==null) return null;
	    node temp=head;
	    while(temp.next.next!=null){
	        temp=temp.next;
	    }
	    temp.next=null;
	    return head;
	}
	

	public static node removeK(node head,int k){
	    if(head==null) return head;
	    if(k==1){
	        head=head.next;
	        return head;
	    }
	    node temp=head;
	    node prev=null;
	    int cnt=0;
	    while(temp!=null){
	        cnt++;
	        if(cnt==k){
	            prev.next=prev.next.next;
	            break;
	        }
	        prev=temp;
	        temp=temp.next;
	    }
	  return head;
	}
	
	
	public static node removeElement(node head,int k){
	    if(head==null) return head;
	    if(head.data==k){
	        head=head.next;
	        return head;
	    }
	    node temp=head;
	    node prev=null;
	    while(temp!=null){
	        if(temp.data==k){
	            prev.next=prev.next.next;
	            break;
	        }
	        prev=temp;
	        temp=temp.next;
	    }
	  return head;
	}
}
