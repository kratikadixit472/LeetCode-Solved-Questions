/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        
        int left = 0 , right = fonts.length-1;
        int ans = -1;
        
        while(left <= right){
            
            int mid = (right + left) / 2;
            
            if(isPossibleToFit(text, w, h, fonts[mid], fontInfo)){
                ans = fonts[mid];
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean isPossibleToFit(String text, int w, int h, int font, FontInfo fontInfo){
        
        int wdt = 0;
        
        if(fontInfo.getHeight(font) > h) return false;
        
        for(char ch : text.toCharArray()){
            
            wdt += fontInfo.getWidth(font, ch);
            
            if(wdt > w) return false;
        }
        
        return true;
    }
}