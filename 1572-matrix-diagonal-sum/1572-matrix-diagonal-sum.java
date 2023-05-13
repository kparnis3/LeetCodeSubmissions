class Solution {
    public int diagonalSum(int[][] mat) {
        int ans = 0;

        int row = mat.length;
        int col = mat[0].length;

        int mid = (int) Math.floor(mat.length/2);
        if(row % 2 != 0){ //odd case
           ans -= mat[mid][mid];
        }
        

        for(int i=0; i<col; i++)
        {
            for(int j=0; j<row; j++)
            {
               if(i==j)
               {
                   // Primary Diagonal
                   ans += mat[i][j];
               }
               
               if(i+j==row-1)
               {
                   // Secondary Diagonal
                   ans += mat[i][j];

               }

            }
        }

        return ans;
    }
}