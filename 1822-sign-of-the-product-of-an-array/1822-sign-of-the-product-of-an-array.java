class Solution {
    public int arraySign(int[] nums) {
        boolean pos = true;

        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]==0){ return 0; }
            
            // Multi 1 * -1
            if(pos==true && nums[i] < 0){
                pos = false;
            }
            // Multi -1 * -1
            else if(pos==false && nums[i] < 0){
                pos = true;
            }

        }

        if(pos){
            return 1;
        }
        else{
            return -1;
        }
    }
}