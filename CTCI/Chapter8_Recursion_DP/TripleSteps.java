import java.util.Scanner;
import java.util.Arrays;
public class TripleSteps{

  public static int tripleStepsConstantSpace(int n){
    if( n < 3) return n;
    int a = 1;
    int b = 1;
    int c = 2;


    int cnt = c;
    for( int i = 3; i <= n; i++){
        cnt = a + b + c;
        a =  b;
        b = c;
        c = cnt;
    }
    return cnt;
  }



  public static int tripleSteps(int n){
      int[] memo = new int[n+1];
      Arrays.fill(memo,-1);
      return tripleSteps(n, memo);
    }
  public static int tripleSteps(int n, int[] memo){
      if(n < 0){
        return 0;
      }else if (n == 0){
        return 1;
      }else if(memo[n] != -1) {
        return memo[n];
      }else{
        memo[n] = tripleSteps(n-1,memo) + tripleSteps(n-2,memo) + tripleSteps(n-3,memo);
      }
      return memo[n];
  }
  public static void main(String[] args){

  Scanner in = new Scanner(System.in);

  while(true){
    int n = in.nextInt();
    if(n == -1) break;
    System.out.println("Triple Steps " + tripleSteps(n));
    System.out.println("Triple Steps using constant space " + tripleStepsConstantSpace(n));
  }
  System.out.println("Thank you");

  }
}
