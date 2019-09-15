class BinarySearch {

  public static int search(int[] arr, int key) {
    if(arr.length == 0) return -1;
    int s = 0;
    int e = n;
    boolean isAsceding = arr[0] < arr[arr.length -1];
    while(s <= e){
      int mid = (s + e)/2;
      if(arr[mid] == key) return mid;
      if(isAsceding){ //ascending list
        if(key < arr[mid]) e = mid-1;
        else s = mid+1;
      }else{
        if(key > arr[mid]) e = mid-1;
        else s = mid+1;
      }
      //if((arr[0] < arr[n] && key < arr[mid]) || (arr[0] > arr[n] && key > arr[mid])) e = mid;
      //else s = mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
    System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
  }
}