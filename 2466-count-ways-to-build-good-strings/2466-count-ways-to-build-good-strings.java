class Solution {
    private int[] cache;
    private static final int MOD = (int) 1e9 + 7;    
    private int L;
    private int H;
    private int Z;
    private int O;
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        // We want a number thats length is between [low, high] low, .... , high.
        // If length is between low=3, high=3 then string must be length 3.
        // If length is between low=3, high=4 then string can be length 3 and 4.
        
        //Characters in string have to be between 0 and 1.
        //If a zero is added, it has to be added the amount of times equivelent to zero p             param.
        
        /*
            DFS Tree low=3 high=3, zero=1, one=1, 2^n
            
            
                                      [ ] Combination tree
                                 /            \ 
                                0              1 length = 1              
                             /     \        /      \
                            00     01      10      11 length = 2
                           / \     / \    /  \    /  \
                         000 001 010 011 100 101 110 111  length 3    
                         
                                      [ ]   Length tree 
                                 /            \ 
                                1              1             
                             /     \         /    \
                            2       2       2      2 length = 2
                           / \     / \    /  \    /  \
                         3    3   3   3  3    3  3    3  length 3 
         
        */
        
        L = low;
        H = high;
        Z = zero;
        O = one;
        
        cache = new int[high+1];
        
        for(int i=0; i<cache.length; i++){
            cache[i] = -1;
        }
        
        return DFS(0);
        
        
    }
    
    public int DFS(int length)
    {   
        //Base case if length > high.
        if (length > H)
        {
            return 0;
        }
        
        //Base case if length > high.
        if(cache[length] != -1)
        {
            return cache[length];
        }
        
        //So far result is in high but we havent tested low.
        cache[length] = 0;
        
        // If our length is within low and high result is one.
        if(length >= L)
        {
            cache[length] = 1;
        }
        
        // Open up left and right trees.
        cache[length] += DFS(length + Z) + DFS(length + O);
        
        
        return cache[length] %= MOD;

    }
}