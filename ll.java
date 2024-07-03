import java.util.*;
public class ll{
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        System.out.print(remove(str));
    }
    public static String remove(String str){
        StringBuilder result= new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            if(ch!='a'&&ch!='e'&&ch!='i'&&ch!='o'&&ch!='u'){
                result.append(ch);
            }
        }
           return result.toString();
    }
}