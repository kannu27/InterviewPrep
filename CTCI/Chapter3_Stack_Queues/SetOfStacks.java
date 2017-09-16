import java.util.*;
public class SetOfStacks{
  private ArrayList<Stack<Character>> stacks;
  private int threshold;

  public SetOfStacks(int threshold){
    this.threshold = threshold;
    stacks = new ArrayList<Stack<Character>>();
  }

  public void push(Character ch){

    Stack<Character> stack = this.getTopStack();
    boolean newStack = false;
    if(stack == null || isFull(stack)){
      stack = new Stack<Character>();
      newStack = true;
    }
     stack.push(ch);
    if(newStack){
        stacks.add(stack);
    }

  }

  public Character pop() throws Exception{
    Stack<Character> stack = this.getTopStack();
    if(stack == null) throw new Exception();
    Character ch = null;
    try{
        ch = stack.pop();
    }catch(Exception e){
      System.out.println("I can't be reached");
    }

    if(stack.isEmpty()) stacks.remove(stack);
    return ch;
  }

  public Stack<Character> getTopStack(){
        if(stacks.size() == 0) return null;
        return stacks.get(stacks.size() -1);
  }

  public boolean isFull(Stack<Character> s){
    if(s.size() >= this.threshold) return true;
    return false;
  }

  public boolean isEmpty(){
    return this.stacks.size() == 0;
  }

  public static void main(String[] args){
    SetOfStacks sets = new SetOfStacks(2);
    sets.push('a');
    sets.push('b');
    sets.push('c');
    sets.push('d');
    sets.push('e');
    try{
      while(!sets.isEmpty()){
          System.out.println(sets.pop());
      }
    }catch(Exception e){
          System.out.println("I can't be reached");
    }
  }

}
