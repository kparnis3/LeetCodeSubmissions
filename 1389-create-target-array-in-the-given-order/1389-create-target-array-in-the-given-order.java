class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
      List<Integer> resultList = new ArrayList<>();
      
      for(int i = 0; i < index.length; i++ )
      {
        // Add number at the end
        if (index[i] > i)
        {
          resultList.add(nums[i]);
        }
        // Add number at position index[i]
        else
        {
          resultList.add(index[i], nums[i]); 
        }

      }

      // Convert List<Integer> to int[]
      int[] result = resultList.stream().mapToInt(i->i).toArray();

      return result;  
    }
}