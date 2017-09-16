import java.util.Arrays;
import java.util.Stack;
public class TowersOfHanoi {

	public TowersOfHanoi(int[] arr){
		this.first = new Stack<Integer>();
		this.last = new Stack<Integer>();
		this.helper = new Stack<Integer>();
		Arrays.sort(arr);
		for(int i = arr.length -1; i >=0; i--){
			this.push(first,arr[i]);
		}
	}
	public void moveDisks(int smallest, int from, int to) throws Exception{
		moveDisks(smallest, from, to, 1);
		System.out.println("Disks moved");
	}

	public void printTowersOfHanoi(){
		System.out.println("Towers of Hanaoi");
		System.out.println("Tower 1:" + getStack(0).toString());

		System.out.println("Tower 2:" + getStack(2).toString());
		//System.out.println("Tower 3:" + getStack(0).toString());

	}
	private void moveDisks(int smallest, int from, int to, int helper) throws Exception{
		//Validate if number of towers present in stack
		if(!validate(smallest, from) || smallest <= 0){
			throw new Exception();
		}

		if(smallest == 1){
			moveDisk(from, to);
			return;
		}else{
			moveDisks(smallest -1,from,helper,to);
			moveDisk(from,to);
			moveDisks(smallest -1,helper,to,from);
			return;
		}

	}

	private void moveDisk(int from, int to) {
		this.getStack(to).push(this.getStack(from).pop());
	}
	private void push(Stack<Integer> first, int i) {
		first.push(i);
	}

	private boolean validate(int smallest, int from) {

		return getStack(from).size() >= smallest;
	}

	private Stack<Integer> getStack(int num){
		if(num == 0) return this.first;
		if(num == 2) return this.last;
		if(num == 1) return this.helper;
		return null;
	}
	/* private instance variable */
	private Stack<Integer> first;
	private Stack<Integer> last;
	private Stack<Integer> helper;


	public static void main(String[] args){

		int[] a = {1,2,3,4,5,6};

		TowersOfHanoi th = new TowersOfHanoi(a);
		th.printTowersOfHanoi();
		try{
			th.moveDisks(a.length, 0, 2);
		}catch(Exception e){
			System.out.println("Illegal paramater value to calling function");
			e.fillInStackTrace();
		}
		th.printTowersOfHanoi();
	}

}
