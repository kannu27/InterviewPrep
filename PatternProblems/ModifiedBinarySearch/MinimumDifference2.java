class MinimumDifference {

  public static int searchMinDiffElement(int[] arr, int key) {
    //handle corner cases;
    if(arr.length == 0) return -1;
    if(arr[0] >= key) return arr[0];
    if(key >= arr[arr.length -1]) return arr[arr.length -1];
    //handle corner cases;
    int s = 0;
    int e = arr.length -1;
    while(s <= e){
      int mid = s  + (e -s)/2;
      if( key < arr[mid]) e = mid -1;
      else if( key > arr[mid]) s = mid + 1;
      else return arr[mid];
    }
  //start == end + 1
    if(arr[s] - key <= key - arr[e]) return arr[s];
      return arr[e];
  }

  public static void main(String[] args) {
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
  }
}
