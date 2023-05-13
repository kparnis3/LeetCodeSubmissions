class Solution {
    // Time -> O(N), Space -> O(N)
    long[] cache;

    public long mostPoints(int[][] questions) {
        cache = new long[questions.length];

        return DFS(0,questions);
    }

    public long DFS(int i, int[][] que)
    {   
        //base case if pointer is at end or over
        if (i >= que.length)
        {
            return 0;
        }
    
        //if branch has already been explored
	    if (cache[i] !=0)
        {
            return cache[i];
        }
        
        
        return cache[i] = Math.max(DFS(i+1, que), //skip question
                                   que[i][0] + DFS(i + 1 + que[i][1], que) //solve current
                                  );

    }
}