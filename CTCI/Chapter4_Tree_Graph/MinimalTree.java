public class MinimalTree{

  public static BSTNode<Integer> minimalTree(int[] arr){
    if(arr.length == 0) return null;
    int start = 0;
    int end = arr.length -1;
    BSTNode<Integer> root  = minimalTree(arr, start, end);
    return root;
  }

  public static BSTNode<Integer> minimalTree(int[] arr, int start, int end){
    if(start > end){
      return null;
    } else if(start == end){
      System.out.println("Inserting" + arr[start]);
      return new BSTNode<Integer>(arr[start], arr[start]);
    }else{
      int mid = (start + end)/2;
      System.out.println("Inserting" + arr[mid]);
      BSTNode<Integer> node = new BSTNode<Integer>(arr[mid], arr[mid]);
      node.left = minimalTree(arr, start, mid -1);
      node.right = minimalTree(arr, mid + 1, end);
      return node;
    }
  }

  public static void main(String[] args){
    int[] arr = {1,2,3,4,5,6,7,8};
    BSTNode<Integer> root = minimalTree(arr);

    root.InOrder(root);

  }
}
