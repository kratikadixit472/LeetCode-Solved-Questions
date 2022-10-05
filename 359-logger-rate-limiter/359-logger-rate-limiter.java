class Logger {

    Map<String, Integer> map;
    
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(map.containsKey(message)){
            if(map.get(message) > timestamp) return false;
        }
        map.put(message, timestamp+10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */