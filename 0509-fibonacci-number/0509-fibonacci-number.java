class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();
    /*
                        4
                       / \
                     3    2 (Explored, +1)
                   /   \
                  2     2 (Explored, +1)
                 / \    
             +1 1   0 
    */
    public int fib(int n) {
        return DFS(n); // Taking top-bottom approach 
    }

     public int DFS(int i)
     {   
        //Base case
        if  (i==0) return 0;
        if  (i==1) return 1;
        
        //Case already explored
        if(cache.containsKey(i)) return cache.get(i);
        
        int result = 0;
         
        //Open left and right
        result = DFS(i-1) + DFS(i-2);
        cache.put(i, result);
        
        return result;
                     
    }
}