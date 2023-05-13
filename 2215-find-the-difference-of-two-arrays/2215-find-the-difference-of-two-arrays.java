class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Convert to sets
        Set<Integer> nums1S = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> nums2S = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        // Get distinct in nums1
        Set<Integer> difference1S = new HashSet<Integer>(nums1S);
        difference1S.removeAll(nums2S);

        // Get distinct in nums2
        Set<Integer> difference2S = new HashSet<Integer>(nums2S);
        difference2S.removeAll(nums1S);

        result.add(new ArrayList<>(difference1S));
        result.add(new ArrayList<>(difference2S));

        return result;
    
}
}