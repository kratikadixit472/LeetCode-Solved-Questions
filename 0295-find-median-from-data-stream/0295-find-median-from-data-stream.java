class MedianFinder {

    List<Integer> al;
    
    public MedianFinder() {
        al = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int i;
        if(al.size() > 0){
            for (i = 0; (i < al.size()  && al.get(i) < num); i++);
            if(i == -1){
                i = 0;
            }
            al.add(i , num);
        }else{
            al.add(num);
        }
    }
    
    public double findMedian() {
        int index = al.size() / 2;
        if(al.size() % 2 == 0) return (double)(al.get(index) + al.get(index - 1)) / 2;
        
        else return al.get(index);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */