class FreqStack {
    
    int maxFreq = 0;
    Map<Integer, Integer> frq;
    Map<Integer, Stack<Integer>> groupMap;
    
    public FreqStack() {
        frq = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int valFrq = frq.getOrDefault(val, 0) + 1;
        frq.put(val, valFrq);
        
        maxFreq = Math.max(maxFreq, valFrq);
        groupMap.putIfAbsent(valFrq, new Stack<>());
        groupMap.get(valFrq).add(val);
    }
    
    public int pop() {
        int val = groupMap.get(maxFreq).pop();
        frq.put(val, frq.getOrDefault(val, 0) - 1);
        
        if(groupMap.get(maxFreq).size() == 0){
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 
 ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
 */