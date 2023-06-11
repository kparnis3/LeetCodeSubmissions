class SnapshotArray {
    /*
        1) SnapshotArray snapshotArr = new SnapshotArray(3);
            [0,0,0]
        2) snapshotArr.set(0,5); 
            [5,0,0]
        3) snapshotArr.snap(); 
            [5,0,0]
            [5,0,0] (when set is called)
            returns 0
        4) snapshotArr.set(0,6);
            [5,0,0] 
            [6,0,0]
        5) snapshotArr.get(0,0);
            returns 5
        
        set using: Map<Index, Map<SnapID, Values>
        get using: BinarySearch (0->4, snap(sid:0), snap(sid:1))
    
    */

    private Map<Integer, TreeMap<Integer,Integer>> indexMap;
    private int snapId=0;
   
    public SnapshotArray(int length) {
      indexMap = new HashMap<>();
    }
    
    public void set(int index, int val) {
        if(!indexMap.containsKey(index)){
            indexMap.put(index, new TreeMap<>());
        }
        indexMap.get(index).put(snapId, val);
    }
    
    public int snap() {
        snapId++;
        return snapId-1;
    }
    
    public int get(int index, int snap_id) {
        
        TreeMap<Integer, Integer> snapValues = indexMap.get(index);
        if (snapValues != null) {
            Map.Entry<Integer, Integer> floorEntry = snapValues.floorEntry(snap_id);
            if (floorEntry != null) {
                return floorEntry.getValue();
            }
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */