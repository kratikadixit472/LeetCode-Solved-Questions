class Solution {
    public int findBlackPixel(char[][] picture, int target) {
        int n = picture.length, m = picture[0].length;
        
        int[] row = new int[n];
        int[] col = new int[m];
        
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        int[] colCount = new int[m];
        
        for(int i = 0; i < n; i++){
            String key = getRowCount(i, m, colCount, picture, target);
            if(key.length() != 0){
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key) == target){
                for(int i = 0; i < key.length(); i++){
                    if(key.charAt(i) == 'B' && colCount[i] == target){
                        count += target;
                    }
                }
            }
        }

        return count;
    }
    private String getRowCount(int row, int m, int[] colCount, char[][] picture, int target){
        
        int rowCnt = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < m; i++){
            if(picture[row][i] == 'B'){
                rowCnt++;
                colCount[i]++;
            }
            sb.append(picture[row][i]);
        }
        if(rowCnt == target){
            return sb.toString();
        }
        return "";
    }
}
