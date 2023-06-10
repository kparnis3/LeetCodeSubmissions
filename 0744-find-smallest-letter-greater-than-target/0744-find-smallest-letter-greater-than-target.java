class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int first = 0;
        int last = letters.length-1;
        
        //Binary Search
        while( first <= last ){  
            int mid = (first + last)/2;  
            
            if(letters[mid] > target) {
                last = mid-1;
            } 
            else{
                first = mid+1;
            }
        }
        
        if(first == letters.length){ //Char doesn't exist
           return letters[0];
        }
       
        return letters[first]; //Found
        
    }
}