class Solution {
    public int largestAltitude(int[] gain) {
        //  -5, 1, 5, 0, -7
        //0 -5,-4, 1, 1, -6 Sum: i + i+1
        
        int highSum = 0;
        int currSum = 0;
        
        for(int i =0; i<gain.length;i++){
            
            currSum += gain[i];
            
            if(highSum < currSum){
                highSum = currSum;
            }
        }
        
        return highSum;
         
    }
}