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

 /*   
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
*/

/*
        int row = -1;
        for(int r=0; r<matrix.length; r++) {
            int c = matrix[r].length - 1;
            if(matrix[r][0] == target || matrix[r][c] == target) {
                return true;
            } else if(matrix[r][0] < target && matrix[r][c] > target) {
                  row = r;
                  break;  
            }
        }

        if(row == -1) {
            return false;
        }

        int l = 0;
        int r = matrix[row].length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(target < matrix[row][mid]) {
                r = mid -1;
            } else if(target > matrix[row][mid]) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
*/

        int l = 0;
        int r = matrix.length - 1;
        int row = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int c = matrix[mid].length - 1;
            if(matrix[mid][0] <= target && matrix[mid][c] >= target) {
                row = mid;
                break;  
            } else if(matrix[mid][0] > target) {
                r = mid-1;
            } else if(matrix[mid][c] < target) {
                l = mid+1;
            }
        }

        if(row == -1) {
            return false;
        }

        l = 0;
        r = matrix[row].length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(target < matrix[row][mid]) {
                r = mid -1;
            } else if(target > matrix[row][mid]) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
