class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for (int i = 0; i < rows; i++) {
            int start = 0;
            int end = cols - 1;
            
            // Perform binary search within the row
            while (start <= end) {
                int mid = start + (end - start) / 2; // Calculate the middle index

                if (grid[i][mid] < 0) {
                    // If the current element is negative, search in the left half
                    end = mid - 1;
                } else {
                    // If the current element is non-negative, search in the right half
                    start = mid + 1;
                }
            }
            
            // The count of negative numbers in the row is equal to the number of elements
            // from the start index to the end of the row (cols - start)
            count += (cols - start);
        }

        return count;
        
    }

}