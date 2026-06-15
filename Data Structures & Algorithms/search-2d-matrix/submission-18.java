class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int l = 0;
        int r = (rows * cols) - 1;

        while(l <= r) {
            int mid  = l + ((r - l) / 2);
            int ri = mid / cols;
            int ci = mid % cols;
            
            if(matrix[ri][ci] == target) {
                return true;
            }

            if(target < matrix[ri][ci]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }    
}
