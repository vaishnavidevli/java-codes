 import java.util.*;
public class stacks{
    public static void pushatbottom(Stack<Integer>s,int data){
        if(s.empty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushatbottom(s,data);
        s.push(top);
    }
    public static String reversestring(String str){
        StringBuilder result=new StringBuilder();
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }
        while(!s.empty()){
            char top=s.pop();
            result.append(top);
        }
        return result.toString();
    }
    public static void reverseStack(Stack<Integer>s){
        if(s.empty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushatbottom(s,top);
    }
    public static void printstack(Stack<Integer>s){
        while(!s.empty()){
            System.out.println(s.pop());
        }
    }
    public static void stockspan(int arr[],int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<arr.length;i++){
            while(!s.empty() && arr[i]>arr[s.peek()]){
                s.pop();
            }
            if(s.empty()){
                span[i]=i+1;
            }else{
                int prevhigh=s.peek();
                span[i]=i-prevhigh;
            }
            s.push(i);
        }
    }
    public static void nextgreater(int arr[],int greater[]){
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.empty() && arr[i]>arr[s.peek()]){
                s.pop();
            }
            if(s.empty()){
                greater[i]=-1;
            }else{
                greater[i]=arr[s.peek()];
            }
            s.push(i );
        }
        for(int i=0;i<greater.length;i++){
            System.out.print(greater[i]+ " ");
        }
        System.out.println();
    }
    public static boolean validparentheses(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }else{
                if(s.empty()){
                    return false;
                }
                if((s.peek()=='(' && ch==')') || 
                (s.peek()=='[' && ch==']') || 
                (s.peek()=='{' && ch=='}')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.empty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String args[]){
        Stack<Integer> s=new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // reverseStack(s);
        // printstack(s);
        // String str="eisha";
        // String result=reversestring(str);
        // System.out.print(result);
        // int arr[]={6,8,0,1,3};
        // int greater[]=new int[arr.length];
        // nextgreater(arr,greater);
        String str="{{[(]}}";
        System.out.print(validparentheses(str));
    }
}