import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCompression {

	public static void main(String[] args) {
		String s = "aabcccccaaa";
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //String s1 = bf.readLine();
		System.out.println("Compressed String is " + compressed(s));
		//System.out.println("Compressed String is " + compressed(s1));

	}

	public static String compressed(String s) {
		// Creates the compressed string using the repeated characters
		if (s.isEmpty()) return s; 
		
		
		StringBuilder result = new StringBuilder();
		int index =0;
		
		int countFrequency = 0;
		
		
		while(index < s.length()){
			countFrequency++;
			if((index + 1) >= s.length() || s.charAt(index) != s.charAt(index + 1)){
				result.append(s.charAt(index));
				result.append(countFrequency);
				countFrequency = 0;				
			}
			
			index++;
			
		}
		
		return (result.length() >= s.length())? s : result.toString();
	}

}
