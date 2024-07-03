public class chat{

public static void rd(int arr[], int arr2[]) {
  for (int i = 0; i < arr.length; i++) {
      boolean ip = true;
      for (int j = 0; j < arr2.length; j++) {
          if (arr[i] == arr2[j]) {
              ip = false;
              break; // Once found, no need to continue checking
          }
      }
      if (ip == true) {
          System.out.print(arr[i] + " ");
      }
  }
}
public static void main(String arg[]){
  int arr[] ={1,2,3,1,4};
  int arr2[]=new int[arr.length];
rd(arr,arr2);
}
}
