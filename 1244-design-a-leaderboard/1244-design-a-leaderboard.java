class Leaderboard {

    Map<Integer, Integer> map;
    
    public Leaderboard() {
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        
        if(!map.containsKey(playerId)){
            map.put(playerId , 0);
        }
        map.put(playerId, map.get(playerId)+score);
    }
    
    public int top(int K) {
        List<Integer> al = new ArrayList<>(map.values());
        Collections.sort(al, Collections.reverseOrder());
        
        int topScore = 0;
        
        for(int i = 0; i < K; i++){
            topScore += al.get(i);
        }
        return topScore;
    }
    
    public void reset(int playerId) {
        map.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */