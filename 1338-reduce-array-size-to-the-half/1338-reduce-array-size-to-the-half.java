class Solution {
    public int minSetSize(int[] arr) {
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
           // System.out.println(entry.getValue()+" "+ entry.getKey()+" "+ pq.size());
        }
        
        int n = arr.length;
        int N = n, cnt = 0;
        
        while(pq.size() > 0 && N > n / 2){
            
            int val = pq.poll().getValue(); 
            
            N = N - val;
            cnt++;
            //System.out.print(N+" "+" "+val+", ");
            
        }
        
        return cnt;
    }
}

//(b.getValue() == a.getValue()) ?  Integer.compare(a.getKey(), b.getKey()) : 