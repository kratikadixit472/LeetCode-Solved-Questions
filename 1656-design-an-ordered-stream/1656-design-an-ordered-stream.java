class OrderedStream {

    String[] res;
    int ptr;
    
    public OrderedStream(int n) {
        ptr = 0;
        res = new String[n];
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> al = new ArrayList<>();
        
        res[idKey - 1] = value;
        
        while(ptr < res.length && res[ptr] != null){
            al.add(res[ptr]);
            ptr++;
        }
        return al;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */