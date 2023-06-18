class Solution {
    
    Map<Integer, Integer> cache = new HashMap<>();
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        int answer = 0;
        
        for (int i = 0; i < n; ++i)
        {
            answer = Math.max(answer, DFS(i, headID, manager, informTime));
        }

        return answer;
    }
    
    int DFS(int i, int headID, int[] manager, int[] informTime) {
        
        if (cache.containsKey(i))
        {
           return cache.get(i); 
        }
        
        if (i == headID) //ignore head
        {
            return 0;
        }

        int parent = manager[i];
        cache.put(i, informTime[parent] + DFS(parent, headID, manager, informTime));
        
        return cache.get(i);
  }
}