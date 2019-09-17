import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String s, int k) {
    if(s == null || s.length() == 0 || k == 0) return 0;
        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
        int start = 0;
        int maxLength = 0;
        for(int end = 0;end < s.length(); end++ ){
            charFreq.put(s.charAt(end), charFreq.getOrDefault(s.charAt(end),0) + 1);
            int numDChar = charFreq.size();
            while(numDChar > k){
                removeCharFreq(charFreq,s.charAt(start));
                start++;
                numDChar = charFreq.size();
            }
            maxLength = Math.max(maxLength, end - start + 1);   
        }
        return maxLength;
  }
  private static void removeCharFreq ( HashMap<Character, Integer> freq, Character ch){
        if(freq.containsKey(ch) && freq.get(ch) == 1) freq.remove(ch);
        else freq.put(ch,freq.get(ch) -1);
    }
}
