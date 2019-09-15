class MaxInBitonicArray {

  public static int findMax(int[] arr) {
    if(arr.length == 0) return -1;
    return MaxInBitonicArray(arr, 0 ,arr.length -1);
  }

  private static int MaxInBitonicArray(int[] arr, int s, int e){
    if(s > e) return -1;
    if(s == e){
      return arr[s];
    }
    int mid = ( s + e)/ 2;
    if(arr[mid] > arr[mid -1] && arr[mid] > arr[mid+1]) return arr[mid]; //bitonic max
    if(arr[mid] > arr[mid -1] && arr[mid] < arr[mid + 1]) return MaxInBitonicArray(arr, mid + 1, e);
    return MaxInBitonicArray(arr, s, mid -1);
  }

  public static void main(String[] args) {
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
  }
}
