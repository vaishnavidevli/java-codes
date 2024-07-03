import java.util.*;
public class hashmap{
    public class HashMap<K,V>{
        private class Node{
            K key;
            V val;
            public Node(K key,V val){
                this.key=key;
                this.val=val;
            }
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];
        HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }

        public void put(K key,V val){
            int bi=hashfunction(key);
            int di=searchinll(key,bi);
            if(di!=-1){
                Node node=buckets[bi].get(di);
                node.val=val;
            }else{
                buckets[bi].add(new node(key,val));
                n++;
            }
        }
    }
}