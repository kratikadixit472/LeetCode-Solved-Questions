class BrowserHistory {

    Stack<String> history, future;
    String current;
    
    public BrowserHistory(String homepage) {
        history = new Stack<String>();
        future = new Stack<String>();
        current = homepage;
    }
    
    public void visit(String url) {
        
        history.push(current);
        current = url;
        
        future = new Stack<String>();
    }
    
    public String back(int steps) {
        
        while(steps > 0 && !history.empty()) {
            future.push(current);
            current = history.pop();
            steps--;
        }
        return current;
    }
    
    public String forward(int steps) {
        
        while(steps > 0 && !future.empty()) {
            history.push(current);
            current = future.pop();
            steps--;
        }
        return current;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */