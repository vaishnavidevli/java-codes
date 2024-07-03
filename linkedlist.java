public class linkedlist{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    // addfirst
    public void addFirst(int data){
        Node newnode=new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    //addlast
    public void addLast(int data){
        Node newnode=new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }
    //print ll
    public void print(){
        if(head==null){
            System.out.print("ll is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    //add in the milddle
    public void addMiddle(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newnode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public void removeFirst(){
        //int val=head.data;
        if(size==0){
            System.out.println("ll is empty");
            return;
            //return Integer.MIN_VALUE;
        }
        if(size==1){
            head=tail=null;
            size=0;
            return;
            //return val;
        }
        head=head.next;
        size--;
        //return val;
    }
    //remove last
    public void removeLast(){
        if(size==0){
            System.out.println("ll is empty");
            return;
        }
        if(size==1){
            head=tail=null;
            size=0;
            return;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        prev.next=null;
        tail=prev;
        size--;
        return;
    }
    //search(iterative)
    public boolean itrSearch(int target){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==target){
                return true;
            }
            temp=temp.next;
            i++;
        }
        return false;
    }
    // search recursive
    public int recSearch(int key){
        return helper(head,key);
    }
    //helper function for recursive search
    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1; //backtracking
    }
    //reverse 
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    //remove from end
    public void removefromEnd(int idx){
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(idx==sz){
            head=head.next;
            return;
        }
        int i=0;
        Node prev=head;
        while(i<idx-1){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    // ll is palindrome
    public Node findMid(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean pallindrome(){
        if(head==null || head.next==null){
            return true;
        }
        Node mid=findMid();
        //reverse 2nd half
        Node prev=null;
        Node curr=mid;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;
        //check if equal
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    
    //detect a cycle in a ll
    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    //remove a cycle
    public static void removeCycle(){
        //detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        //find meeting point
        slow=head;
        Node prev=null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;
    }
    

    public static void main(String args[]){
        linkedlist ll=new linkedlist();
         ll.addFirst(1);
         ll.addFirst(2);
    //    // ll.print();
         ll.addLast(3);
    //     //ll.print();
         ll.addLast(2);
         ll.print();
    //     //ll.addMiddle(2,9);
    //     //ll.print();
    //     //System.out.println(ll.size);
    //     //ll.removeLast();
    //     //ll.print();
    //     //System.out.println(ll.size);
    //     //System.out.print(ll.recSearch(9));
    //     //ll.reverse();
    //     //ll.print();
          ll.removefromEnd(2);
          ll.print();
    //     System.out.print(ll.pallindrome());
    }
}