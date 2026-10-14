class LRUCache {


    class Node{
        int key , value;
        Node prev, next;

        public Node(int k, int v){

            this.key = k;
            this.value = v;

        }
    }

   private int capacity;
   private Map<Integer, Node> map;
   private Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new ConcurrentHashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        
        
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {

        Node node;
        if(map.containsKey(key))
        {
             node = map.get(key);
             node.value = value;
            remove(node);
            insert(node);
            return;
        }
         node =  new Node(key,value);
        if(map.size() == capacity)
        {
           
            Node lru = tail.prev;
            int keys = lru.key;
            synchronized (this){
                if(map.size() == capacity)
                remove(lru);
                map.remove(keys);   
            } 
            
        }
           
        map.put(key,node);
        insert(node);

        
    }

    public void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node)
    {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
