import java.util.*;
public class patterns{
    public static void invertedstarpattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }System.out.println();
        }
    }

    public static void halfnopyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }System.out.println();
        }
    }

    public static void char_pattern(int n){
        char ch='A';
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch);
                ch++;
            }System.out.println();
        }

    }

    public static void no_pattern(int n){
        int a=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(a);
                a++;
            }System.out.println();
        }
    }

    public static void hollow_rectangle(int totrows,int totcol){
         for(int i=1;i<=totrows;i++){
            for(int j=1;j<=totcol;j++){
                if(i==1 || j==1 || i==totrows || j==totcol){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }System.out.println();
         }
    }

    public static void inverted_half_pyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print("*");
            }System.out.println();
        }
    }

    public static void inverted_half_pyramid_numbers(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i+1);j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void floyd_triangle(int n){
        int counter=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(counter);
                counter++;
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            } 
            System.out.println();
        }
    }

    public static void butterfly(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public static void solid_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            } 

            for(int j=1;j<=n;j++){
                if(i==1||i==n||j==1||j==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n;i>=1;i--){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=(2*i-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
         invertedstarpattern(n);
        halfnopyramid(n);
        char_pattern(n);
        no_pattern(n);
        hollow_rectangle(4,5);
        inverted_half_pyramid(5);
        inverted_half_pyramid_numbers(5);
       // loyd_triangle(5);
       zero_one_triangle(5);
       butterfly(20);
       solid_rhombus(5);
       hollow_rhombus(5);
       diamond(23);
    }
 }