import java.util.*;
public class DepthList{

  public static void depthListUsingPreOrder(BSTNode<Integer> node, int levelCount,
  ArrayList<LinkedList<Integer>> lists){
    if(node == null) return;
    LinkedList<Integer> list = null;
    if(lists.size() == levelCount){
      list = new LinkedList<Integer>();
      lists.add(list);
    }else{
        list = lists.get(levelCount);
    }
    list.add(node.data);
    depthListUsingPreOrder(node.left,levelCount + 1,lists);
    depthListUsingPreOrder(node.right,levelCount + 1,lists);
  }

  public static void depthListUsingBFS(BSTNode<Integer> root,ArrayList<LinkedList<BSTNode<Integer>>> lists){

      if(root == null) return lists;
      LinkedList<BSTNode<Integer>> list = new LinkedList<BSTNode<Integer>>();
      list.add(root);
      lists.add(list);
      for(int i = 0;i<lists.size();i++){
          LinkedList<BSTNode<Integer>> list = lists.get(i);
        LinkedList<BSTNode<Integer>> newL = new LinkedList<BSTNode<Integer>>();
        for(BSTNode<Integer> x: list){
          if(x.left != null) newL.add(x.left);
          if(x.right != null) newL.add(x.right);
        }
        if(!newL.isEmpty()){
          lists.get(newL);
        }
      }
  }

  public static void main(String[] args){
    int[] arr = {1,2,3,4,5,6,7,8};
    BSTNode<Integer> root = MinimalTree.minimalTree(arr);
    ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
    depthListUsingPreOrder(root,0,lists);
    System.out.println(lists.toString());

    ArrayList<LinkedList<BSTNode<Integer>>> lists1 = new ArrayList<LinkedList<Integer>>>();
    depthListUsingBFS(root, lists);
  }
}
