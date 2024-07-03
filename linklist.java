public class linklist{
    public class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;
        }
    }
   public static node head;
   public static node tail;
    int size;
    public static void addfirst(int data){
        node nn =new node(data);
        if(head==null){
           head=tail=null;
           return;
        }
        nn.next=head;
        head=nn;
    }
    public static void addlast(int data){
        node nn = new node(data);
        if(head==null){
            head=tail=null;
            return;
        }
        tail.next=nn;
        tail=nn;
        
    }

    public static void main (String arg[]){
        linklist ll = new linklist(data);
        ll.addfirst(6);
       
    }
}