class Solution {
    int[] cache;
    int[] numS;
    // O(n)

    public int rob(int[] nums) {
        /*
                      0 (index)
             +nums /     \ skip
                  2       1
                 / \     / \ skip
          +nums 4   3   3   2
        */
        
        
        cache = new int[nums.length];
        numS = Arrays.copyOf(nums, nums.length);
        Arrays.fill(cache, -1); //Fill with cache -1
        
        return DFS(0);
    }
    
    public int DFS(int i)
    {   
        //base case if over length
        if (i >= numS.length) return 0;
    
        //if branch has already been explored
	    if (cache[i] != -1)
        {
            return cache[i];
        }
        
        return cache[i] = Math.max(DFS(i+1), //skip question
                                   numS[i] + DFS(i + 2) //solve current
                                  );

    }
}