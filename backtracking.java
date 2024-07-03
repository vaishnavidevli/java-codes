public class backtracking{
    public static void changearr(int arr[],int i,int val){
        if(i==arr.length){
            printarr(arr);
            return;
        }
        arr[i]=val;
        changearr(arr,i+1,val+1);
        arr[i]=arr[i]-2;
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");                            
        }
        System.out.println();
    }
    public static void findper(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newstr=str.substring(0,i)+str.substring(i+1);
            findper(newstr,ans+curr);
        }
    }

    public static void nqueens(char board[][],int i){
        if(i==board.length){
            //printboard(board);
            return;
        }
        for(int j=0;j<board.length;j++){ //chance
            System.out.println("(" + i + "," + j + ")");
            if (issafe(board,i,j)==true){
                board[i][j]='Q';
                printboard(board);
                nqueens(board,i+1);
                
                board[i][j]='.';
                printboard(board);
            }
        }
    }
    public static boolean issafe(char board[][],int row,int col){
        //vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonal legt up
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diagonal right up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void printboard(char board[][]){
        System.out.println("-----chess board------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    // public static boolean sudokusolver(int sudoku[][],int row,int col){
    //     if(row==9){
    //         return true;
    //     }
    //     int nextrow=row,nextcol=col+1;
    //     if((col+1)==9){
    //         nextrow=row+1;
    //         nextcol=0;
    //     }
    //     if(sudoku[row][col]!=0){
    //         return sudokusolver(sudoku,nextrow,nextcol);
    //     }
    //     for(int digit=1;digit<=9;digit++){
    //         if(issafe(sudoku,row,col,digit)){
    //             sudoku[row][col]=digit;
    //             if(sudokusolver(sudoku,nextrow,nextcol)){
    //                 return true;
    //             }
    //             sudoku[row][col]=0;
    //         }
    //     }
    //     return false;
    // }
    public static void main(String args[]){
        //int arr[]=new int[5];
        // changearr(arr,0,1);  
        // printarr(arr);
        // printsubsets("abc","",0);
        // findper("abc","");
        int n=3;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }
        nqueens(board,0);
        // int sudoku[][]={{0,0,8,0,0,0,0,0,0}
        // {1,9,0,1,5,7,0,0,2},
        // {0,0,3,0,0,4,1,9,0},
        // {0,0,3,0,0,4,1,9,0},
        // {1,8,5,0,6,0,0,2,0},
        // {0,0,0,0,2,0,0,6,0},
        // {9,6,0,4,0,5,3,0,0},
        // {0,3,0,0,7,2,0,0,4},
        // {0,4,9,0,3,0,0,5,7},
        // {8,2,7,0,0,9,0,1,3}};
        // if(sudokusolver(sudoku,0,0)){
        //     System.out.println("solution exists");
        //     printsudoku(sudoku);
        // }else{
        //     System.out.println("does not exists");
        // }
    }
    public static void printsubsets(String str,String ans,int i){
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        char currchar=str.charAt(i);
        printsubsets(str,ans+currchar,i+1);
        printsubsets(str,ans,i+1);
    }
}