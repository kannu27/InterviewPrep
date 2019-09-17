class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    if(arr.length == 0 || k > arr.length || k == 0) return -1;
    int sum = 0;
    int max = 0;
    int start = 0;
    for(int end = 0; end < arr.length; end++){
      sum += arr[end];
      if(end >= k-1) {
        max = Math.max(max, sum);
        sum -= arr[start++];     
    }
    return max;
  }
}
