class Solution {
    // Time O(m*n)
    // Space O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();

        final int m = matrix.length;
        final int n = matrix[0].length;

        int minRow_n = 0;
        int minCol_m = 0;
        int maxRow_n = matrix.length-1;
        int maxCol_m = matrix[0].length-1;

        // Output size = size of m*n
        while(ans.size() < m*n)
        {  
            // Move left to right
            for(int j = minCol_m; j<= maxCol_m && ans.size() < m*n; j++)
            {   
                //System.out.println(matrix[minRow_n][j]);
                ans.add(matrix[minRow_n][j]);
            }

            // Down
            for(int j = minRow_n+1; j<= maxRow_n && ans.size() < m*n; j++)
            {   
                //System.out.println(matrix[j][maxCol_m]);
                ans.add(matrix[j][maxCol_m]);
            }

            // Move right to left
            for(int j = maxCol_m-1; j >= minCol_m && ans.size() < m*n; j--)
            {   
                //System.out.println(matrix[maxRow_n][j]);
                ans.add(matrix[maxRow_n][j]); 
            }

            // Move up
            for(int j = maxRow_n-1; j >= minRow_n+1 && ans.size() < m*n; j--)
            {
                //System.out.println(matrix[j][minCol_m]);
                ans.add(matrix[j][minCol_m]);  
            }
            
            minCol_m++;
            minRow_n++;
            maxCol_m--;
            maxRow_n--;
        }
 
        return ans;

    }
}