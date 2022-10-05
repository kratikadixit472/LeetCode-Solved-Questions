class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return minHeight(0, 0, shelfWidth, shelfWidth, books, new Integer[books.length][shelfWidth+1]);
    }
    
    private int minHeight(int idx, int hgt, int remainW, int shelfWidth, int[][] books, Integer[][] dp){
        
        if(remainW < 0) return Integer.MAX_VALUE;
        if(idx == books.length) return hgt;
        
        if(dp[idx][remainW] != null) return dp[idx][remainW];
        
        int currHgt = books[idx][1], currW = books[idx][0];
        
        int addinCurr = minHeight(idx+1, Math.max(hgt, currHgt), remainW - currW, shelfWidth, books, dp);
        int addinNext = hgt + minHeight(idx+1, currHgt, shelfWidth - currW, shelfWidth, books, dp);
        
        return dp[idx][remainW] = Math.min(addinCurr, addinNext);
    }
}