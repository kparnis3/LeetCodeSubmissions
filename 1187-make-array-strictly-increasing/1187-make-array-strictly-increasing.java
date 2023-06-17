class Solution {
    
    private static class Pair {
        private int index;
        private int previous;

        public Pair(int index, int previous) {
            this.index = index;
            this.previous = previous;
        }

        public int getIndex() {
            return index;
        }

        public int getPrevious() {
            return previous;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair other = (Pair) obj;
            return index == other.index && previous == other.previous;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, previous);
        }
        
        @Override
        public String toString() {
            return "\n Index: "+getIndex()+", Previous: "+getPrevious()+" ";
        }
    }
    
    private Map<Pair, Integer> cache = new HashMap<>();
    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        
        ArrayList<Integer> distinctArr2 = new ArrayList<>();
        
        //Change arr2 to distinct array
        for (int i = 0; i<arr2.length;i++){
            for (int j = 1; j<arr2.length;j++){
                if(arr2[i]==arr2[j]){
                    i=j;
                    continue;
                }    
            }
            distinctArr2.add(arr2[i]);
        }
        
        //index = 0, previous = -1, arr1, distinctArr2
        int ans = DFS(0, -1, arr1, distinctArr2);
        
        //No way of making arr1 strictly increasing.
        if(ans >= 2001){ 
            return -1;
        }
        
        return ans;
    }
    
    public int DFS(int index, int prev, int[] firArr, ArrayList<Integer> secArr){
        int ans = 0;
        
        if(index == firArr.length){
            return 0;
        }
        
        if(cache.containsKey(new Pair(index, prev))){
            return cache.get(new Pair(index, prev));
        }
        
        int oper = 2_001;
        
        // If arr1[i] greater than previous, leave as is.
        if(firArr[index] > prev){
            oper = DFS(index + 1, firArr[index], firArr, secArr);
        }
        
        // Use binary search for a replacement
        int replaceIndex = binSearch(secArr, prev);
        
        //Replace arr1[i], with oper +1
        if(replaceIndex < secArr.size()){
            oper = Math.min(oper, 1 + DFS(index + 1, secArr.get(replaceIndex), firArr, secArr));
        }
        
        cache.put(new Pair(index, prev), oper);
         
        return oper;
    }
    
    
    // find the index of the smallest value in arr2, which is greater than val (previous)
    public int binSearch(ArrayList<Integer> arr, int val){
        int left = 0;
        int right = arr.size();
        
        while(left < right){
            
            int mid = (left + right) / 2;
            
            if(arr.get(mid) <= val){
                left = mid + 1;
            } else {
                right = mid;
            }
            
        }
        
        return left;
            
    }
    
}