class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < colors.length; i++){
            int c = colors[i];
            
            if(!map.containsKey(c)) map.put(c, new ArrayList<>());
            map.get(c).add(i);
            
        }
        
        for(int[] query : queries){
            int i = query[0], c = query[1];
            if(!map.containsKey(c)) ans.add(-1);
            else{
                List<Integer> al = map.get(c);
                int minDis = Integer.MAX_VALUE;
                
                //System.out.println();
                ans.add(binarySearch(i, map.get(c)));
            }
            
        }
        return ans;
    }
    public int binarySearch(int index, List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < index) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int res = left;
        if (left - 1 >= 0 && index - list.get(left - 1) < list.get(left) - index) {
            res = left - 1;
        }
        return Math.abs(list.get(res) - index);
    }
}