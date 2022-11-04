class MyQueue {

    Stack<Integer> pushSt, popSt;
    
    public MyQueue() {
        pushSt = new Stack<>();
        popSt = new Stack<>();
    }
    
    public void push(int x) {
        while(!popSt.isEmpty()){
            pushSt.add(popSt.pop());
        }
        pushSt.add(x);
        while(!pushSt.isEmpty()){
            popSt.add(pushSt.pop());
        }
    }
    
    public int pop() {
        
        return popSt.pop();
    }
    
    public int peek() {
        if(popSt.isEmpty()) return -1;
        return popSt.peek();
    }
    
    public boolean empty() {
        return popSt.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */