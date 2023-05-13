class Solution {
    private int maxI;
    private int maxJ;
    private int[] numS1;
    private int[] numS2;
    private int[][] cache;
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        /* Example one, thinking in terms of trees
            [1, 4, 2]  1) 1->1, 4->4  PointerLength i = 3
            [1, 2, 4]  2) 1->1, 2->2  PointerLength j = 3
            
                                1->1 [Pointer i = 0, j = 0]
                               /    \
      [Pointer i = 1, j = 2] 4->4   2->2 [Pointer i = 2, j = 1]

           Example two, thinking in terms of trees
            [2,5,1,2,5]     PointerLength i = 5  
            [10,5,2,1,5,2]  PointerLength j = 6 
                                  
                                2->2 [Pointer i = 0, j = 2]
                           /     |     \
  [Pointer i = 1, j = 4] 5->5   1->1   2->2 etc
                          |     /   \
  [Pointer i = 3, j = 5] 2->2 2->2 5->5
  
           Restructering in terms of Pointer tree (i,j)                                
                                (0,0) i=0, j=0 Equal same num +1
                                  |
                                (1,1) Not equal, branch 0
                                /   \
        Equal, Pointer Limit (1,2) (2,1) Equal, Pointer Limit +1

        */
        maxI = nums1.length;
        maxJ = nums2.length;
        numS1 = Arrays.copyOf(nums1, nums1.length);
        numS2 = Arrays.copyOf(nums2, nums2.length);
          
        cache = new int[maxI + 1][maxJ + 1];
        
        //set cache to empthy
        for(int i=0; i<=maxI; i++){
            for(int j=0; j<=maxJ; j++){
                cache[i][j] = -1;
            }   
        }
        
        return DFS(0,0);
        
    }
    
    public int DFS(int i, int j)
    {   
        //Base case, if we are out of bounds.
        if(i == maxI || j == maxJ){
            return 0;
        }
        
        // Already Explored
        if(cache[i][j] != -1){
            return cache[i][j];
        }
        
        // If we match
        if(numS1[i] == numS2[j]){
            cache[i][j] = 1 + DFS(i+1, j+1);
        }else{
            cache[i][j] = Math.max(DFS(i+1,j), DFS(i, j+1));
        }
        
        return cache[i][j];
                
    }
}