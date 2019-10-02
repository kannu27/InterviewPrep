public class CountTriplets {
    public static void main(String args[]) {
      int[] arr = {1, 1, 1, 2, 2};
      
      System.out.println(countTriplets(arr));
    }
    private static int countTriplets(int[] nums){
        if(nums.length == 0) return 0;
        int count = 0;
        int maxVal = nums[0];
        //Getting the max val
        for(int n : nums){
            maxVal = Math.max(n, maxVal);    
        }
        
        int[] freq = new int[maxVal + 1];
        
        ///Creating the frequency of numbers
        for(int n : nums){
            freq[n]++;
        }
        
        //There are 4 cases 
        //0,0,0
        count += (freq[0] * freq[0] -1 * freq[0] -2) / 6;
        
        //0, x,x
        for(int i = 1; i < freq.length; i++){
            count += freq[0] * ( freq[i]  * (freq[i] -1)) / 2;    
        }
        
        //x,x,2x
        for(int i = 1; 2 * i <= maxVal; i++){
            count += (freq[i] *  (freq[i] -1)) /2   * (freq[2 * i]);    
        }
        //x,y,x+y
        for(int i = 1; i < freq.length; i++){
            for(int j = i+1; i + j <= maxVal; j++)
            count += freq[i] *  freq[j] * freq[i + j];    
        }
        return count;
        
    }
}
