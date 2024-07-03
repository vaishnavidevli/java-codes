import java.util.*;
public class dp{
    public static int knapsackR(int val[],int wt[],int n,int c,int dp[][]){
        if(n==0 || c==0){
            return 0;
        }
        if(dp[n][c]!=-1){
            return dp[n][c];
        }
        //include
        if(c>=wt[n-1]){
            int ans1=val[n-1] +knapsackR(val, wt, n-1, c-wt[n-1],dp);
            int ans2=knapsackR(val, wt, n-1, c,dp);
            dp[n][c] =Math.max(ans1,ans2);
            return dp[n][c];
        }
        //exclude
        else{
            dp[n][c]= knapsackR(val, wt, n-1, c,dp);
            return dp[n][c];
        }
    }
    public static void printdp(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int knapsackT(int val[],int wt[],int c){
         int n=val.length;
         int dp[][]=new int[n+1][c+1];
         for(int i=0;i<n+1;i++){
            dp[i][0]=0;
         }
         for(int j=0;j<c+1;j++){
            dp[0][j]=0;
         }

         for(int i=1;i<n+1;i++){
            for(int j=1;j<c+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                if(j>=w){
                    int incprofit= v+ dp[i-1][j-w];
                    int excprofit=dp[i-1][j];
                    dp[i][j]=Math.max(incprofit,excprofit);
                }else{
                    int excprofit=dp[i-1][j];
                    dp[i][j]=excprofit;
                }
            }
         }
         return dp[n][c];
    }
    public static int lcs(String str1,String str2,int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        //same
        if(str1.charAt(n-1)== str2.charAt(m-1)){
            dp[n][m]=lcs(str1,str2,n-1,m-1,dp)+1;
        }else{
            int ans1=lcs(str1,str2,n-1,m,dp);
            int ans2=lcs(str1,str2,n,m-1,dp);
            dp[n][m]= Math.max(ans1,ans2);
        }
        return dp[n][m];
    }
    public static int lcsT(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //same
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                //different
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static int lcsub(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        int ans=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);

                }else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
    public static int lcsarr(int arr[],int arr2[]){
        int n=arr.length;
        int m=arr2.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static int lis(int arr[]){
        int n=arr.length;
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        int arr2[]=new int[set.size()];
        int i=0;
        for(int num:set){
            arr2[i]=num;
            i++;
        }
        Arrays.sort(arr2);
        return lcsarr(arr,arr2);
    }
    public static void main(String args[]){
       // int val[]={15,14,10,45,30};
       // int wt[]={2,5,1,3,4};
       // int c=7;
       // int dp[][]=new int[val.length +1][c+1];
       // for(int i=0;i<dp.length;i++){
       //     for(int j=0;j<dp[0].length;j++){
       //         dp[i][j]=-1;
       //     }
       // }
       // System.out.println(knapsackT(val,wt,c));
       // printdp(dp);

       // String str1="abcdae";
       // String str2="acidae";
       // int n=str1.length();
       // int m=str2.length();
       // int dp[][]=new int[n+1][m+1];
       // for(int i=0;i<n+1;i++){
       //     for(int j=0;j<m+1;j++){
       //         dp[i][j]=-1;
       //     }
       // }
       int arr[]={50,3,10,8,40,80};
       System.out.println(lis(arr));

    }
}