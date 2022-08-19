class LRUCache {

    class Node{
        Node prev= null , next = null;
        
        int key = 0;
        int val = 0;
        public Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }

    int maxCap;
    int size = 0;
    Map<Integer, Node> map;
    
    Node head = null, tail = null;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.maxCap = capacity;
    }

    void addFirst(Node node){
        if(this.size == 0){
            this.head = node;
            this.tail = node;
        }
        
        else{
            this.head.next = node;
            node.prev = head;
            this.head = node;
        }
        size++;
    }
    
    Node removeNode(Node node){
        
        if(this.size == 1){
            this.head = null;
            this.tail = null;
            this.size--;
            
            return node;
        }
        
        else if(node == this.tail) {
            return removeLast(); 
        }

        else{
            Node prevNode = node.prev;
            Node nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            
            node.next = null; 
            node.prev = null;

            size--;
            return node;
        }
       
    }

    Node removeLast(){
        
        if(this.size == 1){
            Node node = tail;
            this.head = null;
            this.tail = null;
            this.size--;
            
            return node;
        }
        
        Node last = tail;
        Node secLast = tail.next;
        
      // System.out.println(last+" "+secLast);
        
        secLast.prev = null;
        last.next = null; 
        tail = secLast;
        
        size--;
        return last;
    }

    void makemostrecent(Node node){
       // if(node == null) return;
        
        if(head == node) return;
        removeNode(node);
        addFirst(node);

    }
    
    int get(int key) {

        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        makemostrecent(node);
        return node.val;
    }

    void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            makemostrecent(node);
        }
        
        else{
            if(this.size == maxCap){
                Node node = removeLast();
                map.remove(node.key);
            }
            
            Node node = new Node(key, value);
            map.put(key, node);
            addFirst(node);
            
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */