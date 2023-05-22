class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] result = new int[k];
        Arrays.sort(nums);
        
        Map<Integer, Integer> map = new HashMap<>(); //Create map with freq
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> keys = map.entrySet().stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());

        for (int i = 0; i < k && i < keys.size(); i++) { //get k most freq
            result[i] = keys.get(i);
        }
        
        return result;
    }
}