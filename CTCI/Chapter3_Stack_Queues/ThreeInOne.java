public class ThreeInOne{
  private int[] top;
  private int[] arr;
  private int maxSize;

  public ThreeInOne(int size){

    this.maxSize  = size;
    top = new int[3];
    for(int i = 0; i < 3; i++){
      top[i] = -1;
    }

    arr = new int[3 * this.maxSize ];
  }

  public void push(int no, int data) throws Exception{
    if(this.isFull(no)) throw new Exception();
    if(this.isEmpty(no)){
      top[no-1]  = this.getStartIndex(no);
      arr[top[no-1]] = data;
    }else{
      arr[++top[no-1]] = data;
    }
  }

  public int pop(int no) throws Exception{
    if(this.isEmpty(no)) throw new Exception();
    int data = arr[top[no-1]--];
    if(top[no-1] < getStartIndex(no)){
      top[no-1] = -1;
    }
    System.out.println("Poped stack"  + no + ": " + data);
    return data;
  }

  public boolean isFull(int no){
    int x = getlastIndex(no);
    return top[no-1] >= x;
  }

  public int getlastIndex(int no){
    return (3 * no) - 1;
  }

  public boolean isEmpty(int no){
    return top[no-1] == -1;
  }

  public int getStartIndex(int  no){
    return 3 * (no-1);
  }

  public void printStackList(){
    for(int i = 0; i < 3 * maxSize; i++){
      System.out.println("index " + i + "value is : " + this.arr[i]);
    }
  }
  public void printStackTopList(){
    for(int i = 0; i < 3 ; i++){
      System.out.println("stack top " + i + "value is : " + this.top[i]);
    }
  }


  public static void main(String[] args){
    ThreeInOne stack = new ThreeInOne(3);
    try{
      stack.push(2, 1);
      stack.push(2, 2);
      stack.push(2, 3);
      // System.out.println("start index of 1" + stack.getStartIndex(1));
      // System.out.println("start index of 2" + stack.getStartIndex(2));
      // System.out.println("start index of 3" + stack.getStartIndex(3));

      while(!stack.isEmpty(2)){
        System.out.println("top is at " + stack.top[1]);
        stack.pop(2);
      }
    }catch(Exception e){
      System.out.println("Caught error");
    }
    stack.printStackTopList();

  }
}
