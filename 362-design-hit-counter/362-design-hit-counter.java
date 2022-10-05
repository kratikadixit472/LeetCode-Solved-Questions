class HitCounter {

    int[] times;
    int[] hits;
    
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if(times[index] != timestamp){
            times[index] = timestamp;
            hits[index] = 1;
        }
        else{
            hits[index]++;
        }
    }
    
    public int getHits(int timestamp) {
        int cnt = 0;
        for(int i = 0 ; i < 300; i++){
            if(timestamp - times[i] < 300){
                cnt += hits[i];
            }
        }
        return cnt;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */