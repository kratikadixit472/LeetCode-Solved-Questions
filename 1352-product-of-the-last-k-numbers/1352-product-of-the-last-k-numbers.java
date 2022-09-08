class ProductOfNumbers {

    List<Integer> al;
    public ProductOfNumbers() {
        al = new ArrayList<>();
        al.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            al = new ArrayList<>();
            al.add(1);
        }
        else al.add(al.get(al.size()-1)* num);
    }
    
    public int getProduct(int k) {
        if(al.size() <= k) return 0;
        return al.get(al.size()-1) / al.get(al.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */