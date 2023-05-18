class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        /*  
            Example 1: n = 6 [0, 1, 2, 3, 4, 5, 6]
            
            0 - > 1
              - > 2 - > 5
            
            3 - > 4 - > 2 - > 5
            
            Ans: [0, 3]
            
            Example 2: n = 5 [0, 1, 2, 3, 4]
            
            0 - > 1 - > 4
            
            3 - > 1 - > 4
            
            2 - > 4
              - > 1 - > 4
            
            Ans: [0, 3, 2]
        */ 
        
        List<Integer> vert = new ArrayList();
        Set<Integer> endSet = new HashSet<Integer>();
        
        //create a set of all end sets
        for (List<Integer> edge: edges) {
            endSet.add(edge.get(1));
        }
        
        // If value isn't in set, add to vertices list
        for (int i = 0; i < n; i++) {
            if (!endSet.contains(i)) {
                vert.add(i);
            }
        }
        
        return vert;
        
    }
}