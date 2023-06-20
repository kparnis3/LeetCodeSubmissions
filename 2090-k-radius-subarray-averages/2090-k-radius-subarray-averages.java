class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int [] result = new int[n];
        Arrays.fill(result,-1); //Start with result array all -1
        int length = 2*k+1; //Left, Right and Middle
        
        if (length > n){
            return result;
        }
        
        long sum = 0;
        
        for(int i=0;i<length; i++){ //Sum starting at index zero 
            sum += nums[i];
        }
        
        result[k] = (int) (sum / length); //First case 
        
        int startPoint = 0;
        for(int lastPoint = length; lastPoint < n; lastPoint++){
            sum = sum - nums[startPoint] + nums[lastPoint]; //Subtract first element and add the last one
            startPoint++;
            result[lastPoint-k] = (int) (sum / length); //Compute rest
        }
        
        return result;
    }
}