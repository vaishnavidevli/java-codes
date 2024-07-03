public class recursion{
    public static void main(String args[]){
        //System.out.println(fib(3));
         int arr[]={-5,-4,-3,-3,-1};
        // System.out.println(lo(arr,0,-3));
        // System.out.println(fo(arr,0,-3));
        //System.out.println(tilingpr(4));
        String str="eeisha";
        removedup(str,new StringBuilder(""),new boolean[26],0);
    }
    public static void printdec(int n){
        if(n==1){
            System.out.print(1);
            return;
        }
        System.out.println(n);
        printdec(n-1);
    }
    public static void printinc(int n){
        if(n==1){
            System.out.println(1);
            return;
        }
        printinc(n-1);
        System.out.println(n);
    }
    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n * fact(n-1);
    }
    public static int sum(int n){
        if(n==1){
            return 1;
        }
        return n+ sum(n-1);
    }
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int f1=fib(n-1);
        int f2=fib(n-2);
        return f1+f2;
    }
    public static boolean issorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return issorted(arr,i+1);
    }
    public static int fo(int arr[],int i,int key){
        if(i==arr.length-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return fo(arr,i+1,key);
    }
    public static int lo(int arr[],int i,int key){
        if(i==arr.length-1){
            return -1;
        }
        int isfound=lo(arr,i+1,key);
        if(isfound==-1 && arr[i]==key){
            return i;
        }
        return isfound;
    }
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        return x*power(x,n-1);
    }
    //optimised code
    public static int powerr(int x,int n){
        if(n==0){
            return 0;
        }

        int halfpower=power(x,n/2);
        int halfpowersq=halfpower*halfpower;

        if(n%2!=0){
            halfpowersq*=x;
        }
        return halfpowersq;
    }
    public static int tilingpr(int n){
        if(n==0 || n==1){
            return 1;
        }
        int f1=tilingpr(n-1);
        int f2=tilingpr(n-2);
        int f3=f1+f2;
        return f3;
        //return tilingpr(n-1) + tilingpr(n-2);
    }
    public static void removedup(String str,StringBuilder newstr, boolean  map[],int index){
        if(index==str.length()){
            System.out.println(newstr);
        }
        char currchar = str.charAt(index);
        if(map[currchar -'a']==true){
            removedup(str,newstr,map,index+1);
        }else{
            map[currchar -'a']=true;
            removedup(str,newstr.append(currchar),map,index+1);
        }
    }

}