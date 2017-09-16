import java.util.Scanner;
public class KthElementFromLast{
  public static void main(String[] args){
     LinkedListNode<String> list = new LinkedListNode<String>("a");
     list.setNext(new LinkedListNode<String>("b"));
     list.getNext().setNext(new LinkedListNode<String>("d"));
     list.getNext().getNext().setNext(new LinkedListNode<String>("e"));
     list.getNext().getNext().getNext().setNext(new LinkedListNode<String>("f"));
     list.getNext().getNext().getNext().getNext().setNext(new LinkedListNode<String>("g"));

     list.printList();
     Scanner in = new Scanner(System.in);
     System.out.println("Enter the value of K");
     System.out.println(kthEle2(list, in.nextInt()));
  }

  //Best method using two pointer O(N)  time and no extra space;
  private static String kthEle1(LinkedListNode<String> node, int k){
      if(node == null) return "";
      if(k < 0) return "";

      LinkedListNode<String> first = node;
      LinkedListNode<String> second = node;
      while(k > 0 && second != null){
        second = second.getNext();
        k--;
      }
      if(second == null) return "";
      while(second.getNext() != null){
          first = first.getNext();
          second = second.getNext();
      }

      return first.getData();
  }
///Recursive takes O(N) space and time, not the best solution
  private static String kthEle2(LinkedListNode<String> node, int k){
    Result result = new Result();
    result = kthEle2_Recursive(node, k, result);
    if(result.counter == k){
      return result.node.getData();
    }else{
      return "";
    }

  }
  private static Result kthEle2_Recursive(LinkedListNode<String> node, int k, Result result){
    if(node == null){
      result.counter = -1;
      return result;
    }else{
      result = kthEle2_Recursive(node.getNext(), k, result);
      if(result.counter == k){
        return result;
      }else{
        result.node = node;
        result.counter++;
        return result;
      }
    }
  }
   static class Result {
    public LinkedListNode<String> node;
    public int counter;
  }


}
