class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++)
        {
            int xj = queries[i][0];
            int yj = queries[i][1];
            int rj = queries[i][2];
            int count = 0;

            for (int[] point: points){
                int xi = point[0];
                int yi = point[1];   
                if(sq(xi - xj) + sq(yi-yj) <= sq(rj))
                {
                    count++;
                }     
                
            }
            result[i] = count;
        }
        
        return result;
    }

    public int sq(int num)
    {
        return num*num;
    }
}