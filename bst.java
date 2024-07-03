import java.util.*;
class bst{
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
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left,val);
        }else{
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right=delete(root.right,val);
        }
        else if(root.data>val){
            root.left=delete(root.left,val);
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }
            Node is=inordersuccessor(root.right);
            root.data=is.data;
            root.right=delete(root.right,is.data);
        }
        return root;
    }
    public static Node inordersuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printpaths(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            print(path);
        }
        printpaths(root.left,path);
        printpaths(root.right,path);
        path.remove(path.size()-1);
    }
    public static void print(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i));
        }
        System.out.println("null");
    }
    public static boolean validatebst(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        else if(max!=null && root.data>=max.data){
            return false;
        }
        return validatebst(root.left,min,root) && validatebst(root.right,root,max);
    }

    public static void main(String args[]){
        // int nodes[]={5,3,1,4,6,7};
        // Node root=null;
        // for(int i=0;i<nodes.length;i++){
        //     root=insert(root,nodes[i]);
        // }
        Node root=new Node(3);
        root.left=new Node(2);
        root.left.left=new Node(1);
        root.left.right=new Node(4);
        root.right=new Node(5);
        inorder(root);
        //delete(root, 5);
        //inorder(root);
        //printpaths(root,new ArrayList<>());
        if(validatebst(root,null,null)){
            System.out.print("valid");
        }else{
            System.out.print("not valid");
        }
    }
}