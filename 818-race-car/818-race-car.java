class Solution {
    class Pair{
        int pos, speed;
        
        public Pair(int pos, int speed){
            this.pos = pos;
            this.speed = speed;
        }
    }
    
    public int racecar(int target) {
        
        LinkedList<int[]> q = new LinkedList<>();
        Set<Pair> set = new HashSet<>();
        
        //move, pos, speed
        q.add(new int[]{0, 0, 1});
        set.add(new Pair(0, 1));
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            
            int moves = top[0], pos = top[1], speed = top[2];
            if(target == pos) return moves;
            
            Pair p = new Pair(pos, speed);
            if(set.contains(p)) continue;
            
            set.add(p);
            q.add(new int[]{moves+1, pos+speed, speed*=2});
            
            if((pos+speed > target && speed > 0) || (pos+speed < target && speed < 0)){
                if(speed < 0) speed = 1;
                else speed = -1;
                
                q.add(new int[]{moves+1, pos, speed});
            }
        }
        return -1;
    }
}