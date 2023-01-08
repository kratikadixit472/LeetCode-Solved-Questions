class MyCircularDeque {
    class DoubleNode {
        DoubleNode next, prev;
        int val;
        
        public DoubleNode(int val){
            this.val = val;
            next = null;
            prev = null;
        }
    }
    
    DoubleNode head, tail;
    int sz, k;
    
    public MyCircularDeque(int k) {
        head = new DoubleNode(-1);
        tail = new DoubleNode(-1);
        head.prev = tail;
        tail.next = head;
        this.sz = 0;
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if(sz == k) return false;
        DoubleNode node = new DoubleNode(value);
        
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        sz++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(sz == k) return false;
        DoubleNode node = new DoubleNode(value);
        
        node.next = tail.next;
        tail.next.prev = node;
        node.prev = tail;
        tail.next = node;
        sz++;
        return true;
    }
    
    public boolean deleteFront() {
        if(sz == 0) return false;
        
        head.prev.prev.next = head;
        head.prev = head.prev.prev;
        sz--;
        return true;
    }
    
    public boolean deleteLast() {
        if(sz == 0) return false;
        
        tail.next.next.prev = tail;
        tail.next = tail.next.next;
        sz--;
        return true;
    }
    
    public int getFront() {
        if(sz == 0) return -1;
        return head.prev.val;
    }
    
    public int getRear() {
        if(sz == 0) return -1;
        return tail.next.val;
    }
    
    public boolean isEmpty() {
        return (sz == 0) ;
    }
    
    public boolean isFull() {
        return (sz == k) ;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */