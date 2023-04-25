class SmallestInfiniteSet {

    int[] small;
    
    public SmallestInfiniteSet() {
        small = new int[1001];
        Arrays.fill(small, 1);
    }
    
    public int popSmallest() {
        for(int i = 0; i <= 1000; i++){
            if(small[i] != -1) {
                small[i] = -1;
                return i+1;
            }
        }
        return -1;
    }
    
    public void addBack(int num) {
        small[num-1] = 1;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */