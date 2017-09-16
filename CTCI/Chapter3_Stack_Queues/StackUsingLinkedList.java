public class StackUsingLinkedList<T>{
    class StackNode<T>{
      private T data;
      private StackNode<T> next;
      public StackNode(T data){
        this.data = data;
      }
    }
    private StackNode<T> top;

    public void push(T data) {
        StackNode<T> node = new StackNode<T>(data);
        node.next = top;
        top = node;
    }
    public T pop() throws Exception{
        if(isEmpty()) throw new Exception();
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() throws Exception{
      if(!this.isEmpty()) {
        return top.data;
      }else{
        throw new Exception();
      }

    }

    public boolean isEmpty(){
      return top == null;
    }

    public static void main(String[] args){

        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<Integer>();

        try{
          for(int i = 1 ; i < 20; i= i* 2){
                stack.push(i);
          }

          while(!stack.isEmpty()){
            System.out.println(stack.pop());
          }
        }catch(Exception e){
          System.out.println("Error caught");
        }



    }


}
