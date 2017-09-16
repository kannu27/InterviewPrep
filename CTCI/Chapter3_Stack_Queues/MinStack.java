import java.util.Stack;
public class MinStack extends Stack<Integer>{
    private Stack<Integer> s2;

    public MinStack(){
      s2 = new Stack<Integer>();
        }

    public void push(int data){
      super.push(data);
      if(data <= min()){
          s2.push(data);
      }


    }
    public int min(){
      if(s2.isEmpty()) {
        return Integer.MAX_VALUE;
      }else{
        return s2.peek();
      }
    }

    public Integer pop(){
      int data = super.pop();
      if(data == min()){
          s2.pop();
      }

      return data;
    }

    public static void main(String[] args){
      MinStack s = new MinStack();
      s.push(5);
      s.push(1);
      s.push(3);
      s.push(1);
      while(!s.isEmpty()){
        System.out.println("Min is " + s.min());
        System.out.println("pop is" + s.pop());
      }
    }

}
