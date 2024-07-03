public class stack{
    public static class stackx{
        static Arraylist<Integer> list= new Arratlist<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peak(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String arg[]){
        stackx s =new stack;
        s.push(1);
        s.push(2);
        s.push(3);
        while(!=isEmpty()){
            System.out.print(peak)

        }
    }
}