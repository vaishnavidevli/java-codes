public class dandc{
    public static void mergesort(int arr[],int si,int ei){
        int mid=si+(ei-si)/2;
        if(si>=ei){
            return;
        }
        mergesort(arr,si,mid);
        mergesort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

    // QUICK SORT

    public static void quicksort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int pidx=partition(arr,si,ei);
        quicksort(arr,si,pidx-1);
        quicksort(arr,pidx+1,ei);
    }
    public static int partition(int arr[],int si,int ei){
        int pivot=arr[ei];
        int i=si-1;
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }

    // modified binary search
    public static int search(int arr[],int si,int ei,int target){
        if(si>ei){
            return -1;
        }
        //case found
        int mid=(si+ei)/2;
        if(arr[mid]==target){
            return mid;
        }
        // mid on l1
        if(arr[si]<=arr[mid]){
            if(arr[si]<=target && arr[mid]>=target){
                return search(arr,si,mid-1,target);
            }else{
                return search(arr,mid+1,ei,target);
            }
        }
        // mid on l2
        else{
            if(arr[mid]<=target && arr[ei]>=target){
                return search(arr,mid+1,ei,target);
            }else{
                return search(arr,si,mid-1,target);
            }
        }
    }
    public static void main(String args[]){
        int arr[]={4,5,6,7,0,1,2};
        int target=0;
        int taridx=search(arr,0,arr.length-1,target);
        System.out.println(taridx);
        //mergesort(arr,0,arr.length-1);
        //quicksort(arr,0,arr.length-1);
        //printarr(arr);

    }
}