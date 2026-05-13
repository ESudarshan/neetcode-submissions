class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
/*
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
*/
    
        for(int i=0; i<matrix.length; i++) {
            int l = 0;
            int r = matrix[i].length - 1;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(target < matrix[i][mid]) {
                    r = mid -1;
                } else if(target > matrix[i][mid]) {
                    l = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
