import java.util.*;
public class javaa{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTrees{
        static int i=-1;
        public static Node buildtree(int nodes[]){
            i++;
            if(nodes[i]==-1){
                return null;
            }
            Node newnode=new Node(nodes[i]);
            newnode.left=buildtree(nodes);
            newnode.right=buildtree(nodes);
            return newnode;
        }
    }
    static class Infoo{
        int hd;
        Node node;
        public Infoo(int hd,Node node){
            this.hd=hd;
            this.node=node;
        }
    }
    public static void topview(Node root){
        Queue<Infoo> q= new LinkedList<>();
        HashMap<Integer,Node> map= new HashMap<>();
        int min=0;
        int max=0;
        q.add(new Infoo(0,root));
        while(!q.isEmpty()){
            Infoo curr=q.remove();      
                
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd,curr.node);    
            }
            if(curr.node.left!=null){
              q.add(new Infoo(curr.hd-1,curr.node.left));
              min=Math.min(min,curr.hd-1);
            }
            if(curr.node.right!=null){
                q.add(new Infoo(curr.hd+1,curr.node.right));
                max=Math.max(max,curr.hd+1);
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data);
        }
        System.out.println();
    }
    public static void main(String args[]){
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        topview(root);
    }
}