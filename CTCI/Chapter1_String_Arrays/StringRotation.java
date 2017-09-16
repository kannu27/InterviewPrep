public class StringRotation{

  public static void main(String[] args){

    String s1 = "waterbottle";
    String s2 = "erbottlewa";
    StringRotation obj = new StringRotation();
    System.out.println(obj.isStringRotation(s1,s2));
  }

  public boolean isStringRotation(String s1, String s2){
    StringBuilder str = new StringBuilder(s2);
    str = str.append(str);

    String temp  = str.toString();
    return isSubstring(temp, s1);
  }

  public boolean isSubstring(String string, String str){
    return string.indexOf(str) != -1;
  }
}
