class LRUCache {

    class Node{
        int key, val;
        Node next, prev;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    LinkedList<Node> al;
    int maxCap = 0, size = 0;
    Map<Integer, Node> map;
    
    Node head = null, tail = null;
    
    public LRUCache(int capacity) {
        al = new LinkedList<>();
        maxCap = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))  return -1;
        Node node = map.get(key);
        makeMostRecent(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            makeMostRecent(node);
        }
        else{
            if(size == maxCap){
                Node node = removeLast();
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addFirst(node);
        }
    }
    
    private void makeMostRecent(Node node){
        if(head == node) return;
        deleteNode(node);
        addFirst(node);
    }
    
    private void addFirst(Node node){
        if(size == 0){
            head = node;
            tail = node;
        }
        else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }
    
    private void deleteNode(Node node){
        if(size == 1){
            head = null;
            tail = null;
            size--;
            return;
        }
        if(node == tail){
            removeLast();
            return;
        }
        
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
        
        node.prev = null;
        node.next = null;
        size--;
    }
    
    private Node removeLast(){
        Node last = tail;
        if(tail == head){
            tail = null;
            head = null;
        }
        else{
            Node lastNext = tail.prev;
            last.prev = null;
            lastNext.next = null;
            tail = lastNext;
        }
        size--;
        return last;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */