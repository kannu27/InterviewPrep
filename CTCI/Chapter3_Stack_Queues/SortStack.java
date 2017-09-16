import java.util.Stack;
public class SortStack{


  private static Stack<Integer> sortStack(Stack<Integer> stack){
      Stack<Integer> temp = new Stack<Integer>();
      while(!stack.isEmpty()){
        if(temp.isEmpty()){
          temp.push(stack.pop());
        }else if(stack.peek() >= temp.peek()){
          temp.push(stack.pop());
        }else{
          int buff = stack.pop();
          while(!temp.isEmpty()){
            if(buff > temp.peek()){
              temp.push(buff);
              break;
            }else{
              stack.push(temp.pop());
            }
          }
          if(temp.isEmpty()){
            temp.push(buff);
          }
        }

        }
        while(!temp.isEmpty()){
          stack.push(temp.pop());
        }
        return stack;
      }

      public static void main(String[] args){


        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        
        try{
          stack = sortStack(stack);
          while(!stack.isEmpty()){
            System.out.println(stack.pop());
          }
        }catch(Exception e){
          System.out.println("Caught error");
        }



      }
  }
