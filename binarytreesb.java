import java.util.*;

public class binarytreesb{
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
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue <Node> q= new LinkedList <>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currnode=q.remove();
            if(currnode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currnode.data + " ");
                if(currnode.left!=null){
                    q.add(currnode.left);
                }
                if(currnode.right!=null){
                    q.add(currnode.right);
                }
            }
        }

    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh) + 1;
    }
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int lc=count(root.left);
        int rc=count(root.right);
        return lc+rc+1;
    }
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int ls=sum(root.left);
        int rs=sum(root.right);
        return ls+rs+root.data;
    }
    //diameter
    //Approach 1 TC:O(n^2);
    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int op1=diameter(root.left);
        int op2=diameter(root.right);
        int op3=height(root.left) + height(root.right)+1;
        return Math.max(op3,Math.max(op1,op2));
    }
    //Approach 2 TC->O(n)
    static class Info{
        int diam;
        int height;
        public Info(int diam,int height){
            this.diam=diam;
            this.height=height;
        }
    }
    public static Info fastdiameter(Node root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftinfo=fastdiameter(root.left);
        Info rightinfo=fastdiameter(root.right);
        int diam= Math.max(Math.max(leftinfo.diam,rightinfo.diam),leftinfo.height + rightinfo.height +1);
        int height=Math.max(leftinfo.height,rightinfo.height) + 1;
        return new Info(diam,height);
    }
    //subtree
    public static boolean issubtree(Node root,Node subroot){
        if(root==null){
            return false;
        }
        if(root.data==subroot.data){
            if(isidentical(root,subroot)){
                return true;
            }
        }
        return issubtree(root.left,subroot) || issubtree(root.right,subroot);
    }
    public static boolean isidentical(Node node,Node subroot){
        if(node==null && subroot==null){
            return true;
        }
        if(node == null || subroot==null || node.data!=subroot.data){
            return false;
        }
        if(!isidentical(node.left,subroot.left)){
            return false;
        }
        if(!isidentical(node.right,subroot.right)){
            return false;
        }
        return true;
    }
    // TOP VIEW
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
        q.add(null);
        while(!q.isEmpty()){
            Infoo curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{      //null point exception without null
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
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data);
        }
        System.out.println();
    }
    //LCA 
    public static Node lca(Node root,int n1,int n2){
        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node leftlca=lca(root.left,n1,n2);
        Node rightlca=lca(root.right,n1,n2);
        if(leftlca==null){
            return rightlca;
        }
        if(rightlca==null){
            return leftlca;
        }
        return root;
    }
    //MIN diatance
    public static int mindist(Node root,int n1,int n2){
        Node lca1=lca(root,n1,n2);
        int dist1=getdist(lca1,n1);
        int dist2=getdist(lca1,n2);

        return dist1+dist2;
    }
    public static int getdist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftdist=getdist(root.left,n);
        int rightdist=getdist(root.right,n);
        if(leftdist==-1 && rightdist==-1){
            return -1;
        }else if(leftdist==-1){
            return rightdist+1;
        }else{
            return leftdist+1;
        }
    }
    //Kth ancestor
    public static int kancestor(Node root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftdist=kancestor(root.left,n,k);
        int rightdist=kancestor(root.right,n,k);
        if(leftdist==-1 && rightdist==-1){
            return -1;
        }
        int max=Math.max(leftdist,rightdist);
        if(max +1 ==k){
            System.out.println(root.data);
        }
        return max+1;
    }
    public static int transform(Node root){
        if(root==null){
            return 0;
        }
        int leftchild=transform(root.left);
        int rightchild=transform(root.right);
        int newleft=root.left==null?0:root.left.data;
        int newright=root.right==null?0:root.right.data;
        int data=root.data;
        root.data=newleft+leftchild+newright+rightchild;
        return data;
        
    }

    public static void main(String args[]){
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        //levelorder(root);

        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        //System.out.print(mindist(root,4,7));
       // kancestor(root,4,2);
       // Node ans=lca(root,4,7);
        //System.out.print(ans.data);
        topview(subroot);
        //System.out.print(issubtree(root,subroot));
        //System.out.println(diameter(root));
        //transform(root);
        //preorder(root);
    }
}