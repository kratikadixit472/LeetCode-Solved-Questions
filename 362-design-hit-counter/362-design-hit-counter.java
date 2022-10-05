class HitCounter {

    LinkedList<Integer> q;
    
    public HitCounter() {
        q = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        q.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!q.isEmpty()){
            int diff = timestamp - q.peek();
            if(diff >= 300) q.poll();
            else break;
        }
        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */