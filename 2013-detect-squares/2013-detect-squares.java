class DetectSquares {

    Map<String, Integer> map;
    List<int[]> al;
    
    public DetectSquares() {
        map = new HashMap<>();
        al = new ArrayList<>();
    }
    
    public void add(int[] point) {
        al.add(point);
        String s = point[0] + "@" + point[1];
        map.put(s, map.getOrDefault(s, 0) + 1);
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];
        
        int count = 0;
        
        for(int[] p : al){
            int xx = p[0], yy = p[1];
            if(x == xx || y == yy || Math.abs(x-xx) != Math.abs(y - yy)) continue;
            count += map.getOrDefault(x + "@" + yy, 0) * map.getOrDefault(xx + "@" + y, 0);
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */