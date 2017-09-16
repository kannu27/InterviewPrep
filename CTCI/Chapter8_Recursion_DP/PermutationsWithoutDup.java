public class PermutationsWithoutDup{

  public ArrayList<String> PermutationsWithoutDup(String s){

  	if(s.length() == 0) return new ArrayList<String>();

  	return permutationsWD(s,'');

  }
  private ArrayList<String> permutationsWD(String s,char c){
    ArrayList<String> result = new ArrayList<String>();
    if(s.length() == 1){
      StringBuilder sb = new StringBuilder();
      sb.append(c);
      ab.append(s.charAt(0));
      result.add(sb.toString());
      return result;
    }else{
      for(int i = 0; i < s.length(); i++){
        char prepend = s.charAt[i];
        String n = "";
        if(i == 0){
            n = s.substring(i+1);
        }else{
          n = s.substring(0,i) + s.substring(i+1);
        }
        result.addAll(permutationsWD(n,prepend));
      }
    }
  }

  public static void main(String[] args){

    String s = new String("abc");
    ArrayList<String> p = PermutationsWithoutDup(s);
    System.out.println(p);
  }
}
