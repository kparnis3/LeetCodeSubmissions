class Solution {
    public int[][] generateMatrix(int n) {
        List<Integer> ans = new ArrayList<Integer>();

        int[][] result  = new int[n][n];

        int count = 0;

        for(int i=0; i<n; i++)
        {
             for(int j=0; j<n; j++)
            {
                result[i][j] = count;
            }
        }

        result[0][0] = 1;
        if(n == 1) return result;

        int minRow_n = 0;
        int minCol_m = 0;
        int maxRow_n = n-1;
        int maxCol_m = n-1;

        count = 1;
        while(count <= n*n  )
        {  
            // Move left to right
            for(int j = minCol_m; j<= maxCol_m && count <= n*n; j++)
            {
                result[minRow_n][j] = count;
                count++;
            }

            // Down
            for(int j = minRow_n+1; j<= maxRow_n && count <= n*n; j++)
            {   
                result[j][maxCol_m] = count;
                count++;
            }

            // Move right to left
            for(int j = maxCol_m-1; j >= minCol_m && count <= n*n; j--)
            {   
                result[maxRow_n][j] = count;
                count++;

            }

            // Move up
            for(int j = maxRow_n-1; j >= minRow_n+1 && count <= n*n; j--)
            {
                result[j][minCol_m] = count;
                count++;
            }
            
            minCol_m++;
            minRow_n++;
            maxCol_m--;
            maxRow_n--;
        }
     
        return result; 

    }
}