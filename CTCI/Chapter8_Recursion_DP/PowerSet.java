import java.util.ArrayList;
public class PowerSet{

  public static ArrayList<ArrayList<Integer>> powerSet(int[] arr){
    if(arr.length == 0) return null;
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    powerSet(arr,arr.length -1,result);
    return result;
  }

  private static void powerSet(int[] arr, int last, ArrayList<ArrayList<Integer>> result){
      if(last < 0) {
          ArrayList<Integer> a = new ArrayList<Integer>();
          result.add(a);
          return;
      }
        powerSet(arr, last-1,result);
        for(ArrayList<Integer> list : result){
          ArrayList<Integer> copy = (ArrayList<Integer>)list.clone();
          copy.add(arr[last]);
          result.add(copy);
        }
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(arr[last]);
        result.add(a);

        return;
  }

  public static void main(String[] args){
    int[] arr = {1,2,3,4,5};
    ArrayList<ArrayList<Integer>> result = powerSet(arr);

    System.out.println(result);
  }
}
