class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1 == null &&  word2 == null) return 0;
        if(word1 == null || word1.length() == 0) return word2.length();
        if(word2 == null || word2.length() == 0) return word1.length();
        int n = word1.length();
        int m = word2.length();
        int[][] memo = new int[m+1][n+1];
        
        //Fill out base cases
        for(int r = 0; r <= m; r++){
            memo[r][0] = r;
        }
        for(int c = 0; c <= n; c++){
            memo[0][c] = c;
        }
        
        //tabulation
        for(int r = 1; r <=m; r++){
            for(int c = 1; c<=n; c++){
                
                if(word1.charAt(c-1) == word2.charAt(r-1)){
                    memo[r][c] = memo[r-1][c-1];
                }
                else{
                    memo[r][c] = Math.min(memo[r-1][c-1],Math.min(memo[r-1][c], memo[r][c-1])) + 1;
                    
                }    
                
            }
        }
        return memo[m][n];
    }
}
