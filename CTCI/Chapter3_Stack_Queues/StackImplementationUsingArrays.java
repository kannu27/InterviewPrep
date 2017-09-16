public class StackImplementationUsingArrays{
  private static final int MAX_SIZE = 10;
  private int[] stack;
  private int top;

  public StackImplementationUsingArrays(){
    this.stack = new int[MAX_SIZE];
    this.top = -1;
  }

  public void push(int key) throws Exception{
    if(this.isFull()) throw new Exception();
    stack[++top] = key;
  }

  public boolean isFull(){
    return top == MAX_SIZE;
  }
  public boolean isEmpty(){
    return top == -1;
  }
  public int pop() throws Exception{
      if(this.isEmpty()) throw new Exception();
      return stack[top--];

  }
  public int peek() throws Exception{
    if(this.isEmpty()) throw new Exception();
    return stack[top];
  }

  public static void main(String[] args){
    StackImplementationUsingArrays stack = new StackImplementationUsingArrays();
    try{
      for(int i = 0; i < 10; i++){
        stack.push(i);
      }
      while(!stack.isEmpty()){
        System.out.println(stack.pop());
      }
    }catch(Exception e){
      System.out.println("Caught error");
    }

  }
}
