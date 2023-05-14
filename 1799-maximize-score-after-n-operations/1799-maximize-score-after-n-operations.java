class Solution {
    
    // O(2^n*n^2)
    private int[] cache; 
    private int[] numS;
    
    public int maxScore(int[] nums) {
        // nums -> 2 * n
        // gcd(i, j) = i - j * floor(i/j)
        /* 
           Problem constraint is 1 <= n <= 7 (total size 14),
           This allows the use of bitmasking (14 bits)
           [0,0,0,0,0,0] -> [1,1,0,0,0,0] (when using gcd(1,2))
           [1,2,3,4,5,6] -> [1,2,3,4,5,6]

        */
        numS = Arrays.copyOf(nums, nums.length);
        cache = new int[1 << nums.length]; // 2^ (nums array size)
        Arrays.fill(cache, -1); //Fill with cache -1
        
        return DFS(0,1); //Mask = 0, Operations = 1
          
    }
    
    public int DFS(int mask, int op)
    {   
           
        if(cache[mask]!=-1)
        {
            return cache[mask];
        }
        
        cache[mask] = 0;
        
        for (int i = 0; i<numS.length; i++){
            for (int j = i+1; j<numS.length;j++)
            {
                //Using bitmasking
                if(((mask >> i) & 1) == 1 || ((mask >> j) & 1) == 1){ //xx1x AND
                    continue;                                         //0000
                }                                                     //xx0x
                
                int newMask = mask | (1 << i) | (1 << j); //overwrite at location i and j
                int score = op * GCD(numS[i], numS[j]);
                
                cache[mask] = Math.max(score + DFS(newMask, op+1), //Get max score
                                       cache[mask]);
            }
        }
        
        
        return cache[mask];                
    }
    

    public int GCD(int i, int j){ //Euclidean Algorithm
        
        int gcd = 0, a, b;
        a = (i > j) ? i:j; //Set a to greatest 
        b = (i < j) ? i:j; //Set b to greatest
        gcd = b;
        
        while(a % b != 0){ 
            gcd = a % b;
            a = b;
            b = gcd;
        }
    
        return gcd;
    }
}