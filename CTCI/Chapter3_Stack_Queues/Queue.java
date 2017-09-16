public class Queue<T> {
  private Node<T> head;
  private Node<T> tail;

  ///Queue Node
    class Node <T>{
    private T data;
    private Node<T> next;
    public Node(T data){
      this.data = data;
      }
    }

    public void enqueue(T data){
      Node<T> node = new Node<T>(data);
      if(head == null){
          tail = node;
          head = node;
      }else{
        tail.next  = node;
        tail =node;
      }
    }

    public T dequeue() throws Exception{
      if(this.isEmpty()) throw new Exception();
      T data = head.data;
      head = head.next;
      if(head == null){
        tail = null;
      }
      return data;
    }

    public boolean isEmpty(){
      return head == null || tail == null;
    }

    public static void main(String[] args){
      Queue<Integer> queue = new Queue<Integer>();

      try{
        for(int i = 1 ; i < 20; i= i* 2){
            System.out.println(i);
              queue.enqueue(i);
        }

        while(!queue.isEmpty()){
          System.out.println(queue.dequeue());
        }
      }catch(Exception e){
        System.out.println("Error caught");
      }
    }

}
