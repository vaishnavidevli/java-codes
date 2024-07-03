import java.util.*;
public class arraylist{
    public static void main(String args[]){
        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        //  System.out.print(storewater(height));
        

        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.print(printsum1(list,17));

        // ArrayList<Integer> list2=new ArrayList<>();
        // ArrayList<Integer> list3=new ArrayList<>();
        // ArrayList<ArrayList<Integer>> mainl
        //ist=new ArrayList<>();
        // for(int i=0;i<=5;i++){
        //     list.add(i*1);
        //     list2.add(i*2);
        //     list3.add(i*3);
        // }
        // mainlist.add(list);
        // mainlist.add(list2);
        // mainlist.add(list3);
        // System.out.println(mainlist);
        // for(int i=0;i<mainlist.size();i++){
        //     ArrayList<Integer> currlist=mainlist.get(i);
        //     for(int j=0;j<currlist.size();j++){
        //         System.out.print(currlist.get(j) + " ");
        //     }
        //     System.out.println();
        // }

        //reverse
        // for(int i=list.size()-1;i>=0;i--){
        //     System.out.print(list.get(i) + " ");
        // }
        
        //print max
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<list.size();i++){
        //     max=Math.max(max,list.get(i));
        // }       
        // System.out.println("max = " + max);
        
        //swap
        // int idx1=1,idx2=3;
        // int temp=list.get(idx1);
        // list.set(idx1,list.get(idx2));
        // list.set(idx2,temp);
        // System.out.print(list);

        //sorting
        // Collections.sort(list);
        // System.out.print(list);
        // Collections.sort(list,Collections.reverseOrder());
        // System.out.print(list);
    }
    //brute force
    public static int storewater(ArrayList<Integer> height){
        int maxwater =0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int currheight = Math.min(height.get(i),height.get(j));
                int width=j-i;
                int currwater= width*currheight;
                maxwater =Math.max(maxwater,currwater);
            }
        }
        return maxwater;
    }
    //optimised code
    public static int storedwater(ArrayList<Integer> height){
        int maxwater =0,lp=0;
        int rp=height.size()-1;
        while(lp<rp){
            int currheight=Math.min(height.get(lp),height.get(rp));
            int width = rp-lp;
            int currwater=width*currheight;
            maxwater=Math.max(maxwater,currwater);
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxwater;
    }

    //print sum 1 brute force
    public static boolean printsum1(ArrayList<Integer> list,int target){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i) + list.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }

    // pointer approach
    public static boolean printsum11(ArrayList<Integer> list,int target){
        int lp=0;
        int rp=list.size()-1;
        while(lp!=rp){
            if(list.get(lp) + list.get(rp)==target){
                return true;
            }
            if(list.get(lp) + list.get(rp)<target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }

    //pair sum 2
    public static boolean printsum2(ArrayList<Integer> list,int target){
        int bp=-1;
        int n=list.size()-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
        int lp=bp+1; //smallest
        int rp=bp; //largest
        while(lp!=rp){
            if(list.get(lp) + list.get(rp)==target){
                return true;
            }
            if(list.get(lp) + list.get(rp) < target){
                lp=(lp+1)%n;
            }else{
                rp=(n+rp-1)%n;
            }
        }
        return false;
    }
}