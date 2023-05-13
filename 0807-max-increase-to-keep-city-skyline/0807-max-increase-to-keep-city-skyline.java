class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int[] rowMax = new int[grid.length];
        int[] columnMax = new int[grid.length];

        //Get the max of each row and column 
        for (int i = 0 ; i<grid.length; i++ )
        {
            for (int j = 0 ; j<grid.length; j++ )
            {
                rowMax[i] = Math.max( rowMax[i] , grid[i][j]); 
                columnMax[j] =  Math.max( columnMax[j] , grid[i][j] ); 
            }
        }

        int ans = 0;
        /*
          Take the min of the two maxes of the row and columns,
          subtract this by the original, 
          the result is how much it can increase 
        */
        for (int i = 0 ; i<grid.length; i++ )
        {
            for (int j = 0 ; j<grid.length; j++ )
            {   
                ans += Math.min(rowMax[i], columnMax[j]) - grid[i][j];
            }
        }

        return ans;
    }
}