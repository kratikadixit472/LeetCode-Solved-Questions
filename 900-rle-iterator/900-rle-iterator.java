class RLEIterator {

    int [] num;
    int index;
    
    public RLEIterator(int[] encoding) {
        this.num = encoding;
        this.index = 0;
    }
    
    public int next(int n) {
        while(index < num.length){
            if(n > num[index]){
                n -= num[index];
                index += 2;
            }
            else{
                num[index] -= n;
                return num[index+1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */