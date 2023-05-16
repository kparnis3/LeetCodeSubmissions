class Solution {
    int[] cache;
    int[] costS;
    public int minCostClimbingStairs(int[] cost) {
    // Time -> O(n)
        /*
                       0               OR         1        
                 10 /     \ 10                15 / \ 15
                   1       2                    2   3
              15 / \ 15 20 / \ 20
                2   3     3   4             
        
        
        */
             
        cache = new int[cost.length];
        costS = Arrays.copyOf(cost, cost.length);
        Arrays.fill(cache, -1);
        
        // Start from index 0 or 1
        return Math.min(DFS(0), DFS(1));
    }

    
    public int DFS(int i)
    {   
        //base case if over length
        if (i >= costS.length) return 0;
    
        //if branch has already been explored
	    if (cache[i] != -1)
        {
            return cache[i];
        }
        
        cache[i] = costS[i] + Math.min(DFS(i+1), 
                                       DFS(i+2));
        return cache[i];

    }
}