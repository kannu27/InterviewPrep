class MinimumDifference {

  public static int searchMinDiffElement(int[] arr, int key) {
    if(arr.length == 0) return -1;
    int s = 0;
    int e = arr.length -1;
    while(s <= e){
      int mid = s  + (e -s)/2;
      int diff = Math.abs(arr[mid] - key);
      if(mid -1 >= 0 &&  (Math.abs(arr[mid-1] - key) <= diff)) e = mid -1;
      else if ( mid +1 < arr.length &&  (Math.abs(arr[mid+1] - key) <= diff)) s = mid + 1;
      else return arr[mid];

    }
    return arr[s];
  }

  public static void main(String[] args) {
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
  }
}
