
public class MagicIndex{

  /** Finds the magic Index in sorted array with distinct elements*/
  public static int magicIndexSortedDistinct(int[] arr){
    if(arr.length == 0) return -1;
    return magicIndexSortedDistinct(arr, 0, arr.length-1);
  }

  private static int magicIndexSortedDistinct(int[] arr, int s, int e){
        if(s > e) return -1;
        int mid = (s+ e)/2;
        if(arr[mid] == mid) return mid;
        else if(arr[mid]< mid) return magicIndexSortedDistinct(arr,mid +1, e);
        else return magicIndexSortedDistinct(arr,s, mid-1);
  }

  /** Finds the magic Index in sorted array , elements could repeat*/
  public static int magicIndexSorted(int[] arr){
      if(arr.length == 0) return -1;
      return magicIndexSorted(arr, 0, arr.length-1);

  }
  private static int magicIndexSorted(int[] arr, int s, int e){
        if(s > e) return -1;
        int mid = (s+ e)/2;
        if(arr[mid] == mid) return mid;

        //search left
        int left = magicIndexSorted(arr, s, Math.min(mid-1, arr[mid]));
        if(left!= -1){
          return left;
        }
        int right = magicIndexSorted(arr, Math.max(mid+1, arr[mid]),e);
        if(right != -1){
          return right;
        }
        return -1;
  }

  public static void main(String[] args){
      int[] arr = {-10,-5,0,1,2,5};
      System.out.println(magicIndexSortedDistinct(arr));

      int[] arr1 = {-10,-5,0,1,1,4,8};
      System.out.println(magicIndexSorted(arr1));
  }
}
