class CeilingOfANumber {

  public static int searchCeilingOfANumber(int[] arr, int key) {
    if(arr.length == 0 || key > arr[arr.length -1]) return -1;
    int s = 0; 
    int e = arr.length -1;
    while(s <= e){
      int mid = s + (e-s)/2 ;
      if(arr[mid] == key) return mid;
      if(key < arr[mid]) e = mid -1;
      else s = mid + 1;
    }

    return s;
  }

  public static void main(String[] args) {
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
  }
}
