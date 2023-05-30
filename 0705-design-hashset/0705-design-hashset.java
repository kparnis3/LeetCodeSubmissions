class MyHashSet {
    
    private static final int MAX_SIZE = 10_000; // max calls 10^4
    private LinkedList[] hashData;
    
    public MyHashSet() {
        hashData = new LinkedList[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; ++i) {
            hashData[i] = new LinkedList<Integer>(); //instatiate buckets
        }
    }
    
    public void add(int key) {
        if(contains(key)){ // Maintaining set
            return;
        }
        
        int i = key % MAX_SIZE;
        hashData[i].addFirst(key);
    }
    
    public void remove(int key) {
        if(!contains(key)){ // Not in set
            return;
        }
        
        int i = key % MAX_SIZE;
        hashData[i].remove(Integer.valueOf(key)); //ensure correct version
    }
    
    public boolean contains(int key) { //Iterate till found
        int i = key % MAX_SIZE;
        Iterator<Integer> iter = hashData[i].iterator();
        while (iter.hasNext()) {
            Integer e = iter.next();
            if (e == key) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */