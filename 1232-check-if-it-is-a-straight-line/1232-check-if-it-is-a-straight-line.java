class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        if(coordinates.length == 2)
            return true;
        
        int x0 = coordinates[0][0] , x1 = coordinates[1][0];
        int y0 = coordinates[0][1] , y1 = coordinates[1][1];
        
        for(int i = 2 ; i < coordinates.length ; i++)
        {
            int x = coordinates[i][0] , y = coordinates[i][1];
            if((y1 - y0) * (x - x0) != (x1 - x0) * (y - y0))
                return false;
        }
        return true;
    }
}