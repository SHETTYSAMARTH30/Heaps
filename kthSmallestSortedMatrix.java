class kthSmallestSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int count = 0;
        int start = matrix[0][0];
        int end = matrix[n-1][n-1];
        
        //We will perform binary search, not using index but start and end.
        while(start < end){
            
            int mid = start + (end - start)/2;
            
            //It will store the smallest number greater than mid in 1st index and largest number less than or equal to mid in 0th index
            int[] smallLargePair = {matrix[0][0], matrix[n-1][n-1]};
            
            //It gives number of digits less than or equal to mid
            count = countLessEquals(matrix, mid, smallLargePair);
            
            //If count is same as k then smallLargePair[0] will be kth element as it is largest element less than or equal to mid and there are exactly k elements less than mid
            if(count == k)
                return smallLargePair[0];
            
            //If count is less then to find kth smallest element we will have to search higher
            if(count < k)
                start = smallLargePair[1];
            
            //If count is less than k then kth element is less than mid ie it is present within start and mid hence we will search lower
            else
                end = smallLargePair[0];
        }
        
        return start;
    }
    
    public int countLessEquals(int[][] matrix, int mid, int[] smallLargePair){
        
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        
        //It will keep a count of number of elements less than or equal to mid
        int count = 0;
        
        while(row >= 0 && col < n){
            
            if(matrix[row][col] > mid){
                
                //It is used to save smallest number smaller than mid
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                
                //If a cell is more, then we do above and check whether its less than mid or not
                row--;   
            }
            //If value is greater or equal to mid
            else{
                //It is used to save largest number equal or greater than mid
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                
                //If a cell has number <= mid, then all number above it will also be less
                count += row + 1;
                col++;
            }
        }
        
        return count;
    }
}
