public class arrays{
    public static void max_subarray_sum(int numbers[]){
        int maxsum = Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                int currsum=0;
                for(int k=i;k<=j;k++){
                    currsum+=numbers[k];
                 
                }
                System.out.println(currsum);
                if(maxsum<=currsum){
                    maxsum=currsum;
                }
            }
        }
        System.out.println("the maxsum is = " + maxsum);
    }

    // 2nd method

    public static void maxsumarray(int numbers[]){
        int currsum =0;
        int maxsum =Integer.MIN_VALUE;
        int prefix[]=new int[numbers.length];
        prefix[0]=numbers[0];

        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1]+numbers[i];
        }
        for(int i=0;i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                int end=j;
                currsum = start ==0?prefix[end]:prefix[end]-prefix[start-1];
                System.out.println(currsum);
                if(maxsum<currsum){
                    maxsum=currsum;
                }
            }
        }
        System.out.print("max sum is= " + maxsum);

    }

    // kadanes method

    public static void kadanes(int numbers[]){
        int cs=0;
        int ms=Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){
            cs+=numbers[i];
            if(cs<0){
                cs=0;
            }
            System.out.println(cs);
            ms=Math.max(cs,ms);
        }
        System.out.print("our max sum is = " + ms);
    }

    public static void main(String args[]){
        int numbers[]={-2,-3,4,-1,-2,1,5,-3};
        kadanes(numbers);
    }
}
    
    
