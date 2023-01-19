class ExamRoom {

    List<Integer> al;
    int n;
    
    public ExamRoom(int n) {
        al = new ArrayList<>();
        this.n = n;
    }
    
    public int seat() {
        
        if(al.size() == 0){
            al.add(0, 0);
            return 0;
        }
        
        int dis = Math.max(al.get(0) - 0 , n - 1 - al.get(al.size()-1));
        
        for(int i = 0 ; i < al.size()-1; i++){
            dis = Math.max(dis, (al.get(i + 1) - al.get(i)) / 2);
        }
        
        if(al.get(0) == dis){
            al.add(0, 0);
            return 0;
        }
        
        for(int i = 0 ; i < al.size() - 1; i++){
            if((al.get(i + 1) - al.get(i)) / 2 == dis){
                al.add(i+1, (al.get(i + 1) + al.get(i)) / 2);
                return al.get(i+1);
            }
        }
        
        al.add(n-1);
        return n-1;
    }
    
    public void leave(int p) {
        for(int i = 0 ; i < al.size(); i++){
            if(al.get(i) == p){
                al.remove(i);
                return ;
            }
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 0 1 2 3 4 5 6 7 8 9
 | 
 */