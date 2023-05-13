class Solution {
    public int[] decompressRLElist(int[] nums) {

        List<Integer[]> sublists = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        
        // Get a Integer list of sublists ex [2], [4,4,4]
        int len = 0;
        for(int i = 0; i<nums.length; i = i + 2)
        {   
            len += nums[i];
            int f = nums[i];
            int v = nums[i+1];

            for(int j = 0; j<f; j++)
            {
                sublist.add(v);
            }
        }

        //Create list of freq size
        int[] result = new int[len];

        //Concatenate
        for(int i = 0; i < sublist.size(); i++)
        {
            result[i] = sublist.get(i);
        }

        return result;
}
}