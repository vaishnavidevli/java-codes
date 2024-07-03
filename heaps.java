import java.util.*;
public class heaps{
    public static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x=arr.size()-1;
            int p=(x-1)/2;
            //swap
            while(arr.get(x)<arr.get(p)){
                int temp=arr.get(x);
                arr.set(x,arr.get(p));
                arr.set(p,temp);

                x=p;
                p=(x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
        public void Heapify(int i){
            int minindx=i;
            int left=2*i+1;
            int right=2*i+2;
            if(left<arr.size()-1 && arr.get(left)<arr.get(minindx)){
                minindx=left;
            }
            if(right<arr.size()-1 && arr.get(right)<arr.get(minindx)){
                minindx=right;
            }
            if(minindx!=i){
                int temp=arr.get(i);
                arr.set(i,arr.get(minindx));
                arr.set(minindx,temp);
                Heapify(minindx);
            }
        }
        public int remove(){
            int data=arr.get(0);
            //swap
            int temp=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);
            //delete last
            arr.remove(arr.size()-1);
            //heapify
            Heapify(0);
            return data;
        }
    }
    public static void heapify(int i,int arr[],int size){
        int maxidx=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<size && arr[maxidx]<arr[left]){
            maxidx=left;
        }
        if(right<size && arr[maxidx]<arr[right]){
            maxidx=right;
        }
        if(maxidx!=i){
            int temp=arr[i];
            arr[i]=arr[maxidx];
            arr[maxidx]=temp;
            heapify(maxidx,arr,size);
        }
    }
    public static void heapSort(int arr[]){
        //heapify
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(i,arr,n);
        }
        //swap first and last
        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(0, arr,i);
        }
    }

    public static void main(String args[]){
        int arr[]={1,2,4,5,3};
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}