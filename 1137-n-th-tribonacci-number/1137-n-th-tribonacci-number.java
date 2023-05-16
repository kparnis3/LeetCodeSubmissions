class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();
    
    public int tribonacci(int n) {
         return DFS(n); // Taking top-bottom approach 
    }
    
    public int DFS(int i)
     {   
        //Base case
        if  (i==0) return 0;
        if  (i==1 || i==2) return 1;
        
        //Case already explored
        if(cache.containsKey(i)) return cache.get(i);
        
        int result = 0;
         
        //Open left and middle and right
        result = DFS(i-3) + DFS(i-2) + DFS(i-1);
        cache.put(i, result);
        
        return result;
                     
    }
}