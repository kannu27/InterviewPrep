import java.util.HashSet;

public class RemoveDuplicates{
  public static void main(String[] args)
  {
    RemoveDuplicates obj = new RemoveDuplicates();
    LinkedListNode<Integer> head = new LinkedListNode<Integer>(5);
    head.setNext(new LinkedListNode<Integer>(1));
    head.getNext().setNext(new LinkedListNode<Integer>(1));
    head.getNext().getNext().setNext(new LinkedListNode<Integer>(2));
    head.getNext().getNext().getNext().setNext(new LinkedListNode<Integer>(1));
    head.getNext().getNext().getNext().getNext().setNext(new LinkedListNode<Integer>(3));
    head.getNext().getNext().getNext().getNext().getNext().setNext(new LinkedListNode<Integer>(4));
    head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new LinkedListNode<Integer>(6));
    head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new LinkedListNode<Integer>(6));

    head.printList();

    head = obj.removeDup3(head);
    head.printList();
  }

  /** Method 1 - Using hashSEt - O(N) single pass time, O(N) memory */
  private LinkedListNode<Integer> removeDup1(LinkedListNode<Integer> LinkedListNode){
      if(LinkedListNode == null) return LinkedListNode;
      HashSet<Integer> set = new HashSet<Integer>();

      LinkedListNode<Integer> prev = null;
      LinkedListNode<Integer> current = LinkedListNode;
      while(current != null){
        if(set.contains(current.getData())){
            //remove if already present
            prev.setNext(current.getNext());
            current = current.getNext();
        }else{
          set.add(current.getData());
          prev = current;
          current = current.getNext();
        }
      }
      return LinkedListNode;
  }

///No extra space O(N) time -- for current, runner looks ahead if the current is duplicate ,
//and deletes current
  private LinkedListNode<Integer> removeDup2(LinkedListNode<Integer> node){
        if(node == null) return null;
        LinkedListNode<Integer> current = node;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> next = node.getNext();
        while(next!= null){
          int data = current.getData();
          if(isDuplicate(next, data)){
            //remove current
            if(prev == null){
              //remove from head
              node = next;
            }else{
              prev.setNext(next);
            }
          }else{
            prev = current;
          }
          current = next;
          next  = next.getNext();
      }
      return node;
  }

/////No extra space O(N) time -- for current, look ahead and delete the duplicates...more efficient
  private LinkedListNode<Integer> removeDup3(LinkedListNode<Integer> node){

    if(node == null) return null;
    LinkedListNode<Integer> current = node;
    while(current != null){
      LinkedListNode<Integer> prev = current;
      LinkedListNode<Integer> runner = current.getNext();
      int data = current.getData();

      while(runner != null){
        if(runner.getData() == data){
          prev.setNext(runner.getNext());
        }else{
          prev = runner;
        }
        runner = runner.getNext();
      }
      current = current.getNext();
    }
    return node;
  }

  private static boolean isDuplicate(LinkedListNode<Integer> node, int data){
        LinkedListNode<Integer> temp = node;
        while(temp != null){
          if(temp.getData() == data){
            return true;
          }
          temp = temp.getNext();
        }
        return false;
  }

}
