class Solution {
    public int maxValue(int n, int index, int maxSum) {
        /* Binary Search
            Example 2: n=6, index=1, maxSum=10
            
            [9 10 9 8 7 6] sum=49                   
            [8 9  8 7 6 5] sum=43
            [7 8  7 6 5 4] sum=37       ^
            [6 7  6 5 4 3] sum=31       |   
            [5 6  5 4 3 2] sum=25    Binary Search starts here (middle)
            [4 5  4 3 2 1] sum=19       |
            [3 4  3 2 1 1] sum=14       v
            [2 3  2 1 1 1] sum=10 Correct Answer
            [1 2  1 1 1 1] sum=7
            [1 1  1 1 1 1] sum=6
            
            Cases:
            [9 10 9 8 7 6] 
            To get right sum we calculate sum of natural numbers (n(n+1)/2) 
            in our case (9+8+7+6) and sub (5+4+3+2+1), we do the same for the left side.
            
            [3 4  3 2 1 1] 
            To get right sum we calculate sum of natural numbers (n(n+1)/2) 
            in our case (3+2+1) and add all missing ones (1), we do the same for the left side.
        
        */
        long right = n-index-1;
        long left = index;
        
        long high = maxSum;
        long low = 1;
        
        long result = 0;
        
        while(low<=high){
            long mid = (high+low)/2;
            long sum = mid;
            long leftSum = 0;
            long rightSum = 0;
            
            long m=mid-1;
            
            if(right<=m){ //Subtract values not in matrix by sum of values that are in matrix on the right                                  side.
                rightSum = m*(m+1)/2 - (m-right) * (m-right+1)/2; 
            }
            else{ //Add missing ones to sum of values that are in the matrix on the right side.
                rightSum= m*(m+1)/2 + 1*(right-m);
            }
            
            if(left<=m){ //We do the same on the left side.
                leftSum = m*(m+1)/2 - (m-left) * (m-left+1)/2; 
            }
            else{ 
                leftSum= m*(m+1)/2 + 1*(left-m);
            }
            
            sum+= leftSum+rightSum;
            
            if(sum<=maxSum){
                result=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
            
        }
        
        return (int) result;
        
    }
}