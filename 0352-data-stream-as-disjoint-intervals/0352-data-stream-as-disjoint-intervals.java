class SummaryRanges {

    Set<Integer> set;
    
    public SummaryRanges() {
        set = new TreeSet<>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {
        List<int[]> ans = new ArrayList<>();
        int left = -1, right = -1;
        
        for(int val : set){
            if(left < 0){
                left = right = val;
            }
            else if(val == right + 1){
                right = val;
            }
            else{
                ans.add(new int[]{left, right});
                left = right = val;
            }
        }
        ans.add(new int[]{left, right});
        
        return ans.toArray(new int[ans.size()][2]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */