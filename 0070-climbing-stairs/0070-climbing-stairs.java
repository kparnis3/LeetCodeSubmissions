class Solution {
    
    private Map<Integer, Integer> cache = new HashMap<>();
    private int maxN;
    
    public int climbStairs(int n) {
     /*               0 n = 2
                     / \ 
                    1   2
                   /
                  1+1
                
     */
        maxN = n;
        return DFS(0);
    }
    
    
    public int DFS(int i)
    {   
        //Base case
        if  (i==maxN) return 1; // Total should be equal to n
        if  (i>maxN) return 0; // Out of bounds 
        
        //Case already explored
        if(cache.containsKey(i)) return cache.get(i);
        
        int result = 0;
        //Open left and right
        result = DFS(i+1) + DFS(i+2);
        cache.put(i, result);
        
        
        return result;
        
        
                
    }
}