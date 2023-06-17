class Solution {
    public int equalPairs(int[][] grid) {
        
        int result = 0;
        
        int n = grid.length;
        
        Map<String, Integer> freqMap = new HashMap<>();
    
        for(int[] row: grid){
            String rowString = Arrays.toString(row);

            if (freqMap.containsKey(rowString)) {
                freqMap.put(rowString, freqMap.get(rowString) + 1);
            } 
            else {
                freqMap.put(rowString, 1);
            }
        }
        
        for(int c = 0; c < n; c++){
            int[] colArray = new int[n];
            for(int r = 0; r < n; r++){
                colArray[r] = grid[r][c];
            }
            
            String Arr = Arrays.toString(colArray);
            if (freqMap.containsKey(Arr)) {
                result += freqMap.get(Arr);
            } 
        }
        
        return result;
    
    }
}