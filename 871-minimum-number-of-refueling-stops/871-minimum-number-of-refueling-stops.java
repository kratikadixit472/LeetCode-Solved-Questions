class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        if(target == startFuel || target < startFuel) return 0;
        
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int currentFuel = startFuel;
        
        
        for(int [] station : stations){
            int nextStation = station[0];
            int fuelAtNextStation = station[1];
            
            while(currentFuel < nextStation){
                if(pq.isEmpty()) return -1;
                int maxFuel = pq.poll();
                currentFuel += maxFuel;
                count++;
            }
            pq.add(fuelAtNextStation);
            
        }
        
        while(currentFuel < target){
            if(pq.isEmpty()) return -1;
            int maxFuel = pq.poll();
            
            currentFuel += maxFuel;
            count++;
        }
        
        return count;
    }
}