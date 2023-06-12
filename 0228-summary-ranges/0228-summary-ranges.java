class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<>();
        
        int from = 0;
        
        for(int i = 0; i<nums.length; i++){
            from = nums[i];  
            
            if (i == nums.length - 1 || nums[i] != nums[i + 1] - 1) { //If at end or numbers arent covered from starting
                resultList.add(from + "");
                continue;
            }
            
            int j = 0;
            
            for(j = i+1; j<=nums.length; j++){ //If at end or numbers arent covered break
                if (j == nums.length - 1 || nums[j] != nums[j + 1] - 1) {
                    break;
                }
            }
            
            resultList.add(from+"->"+nums[j]);
            
            i = j; //continue at j
        }
        
        
        return resultList;
    }
}