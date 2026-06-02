class Solution {

    int[][] mem;

    public boolean checkValidString(String s) {
        int n = s.length();
        mem = new int[n][n];
        for(int[] m: mem) {
            Arrays.fill(m, -1);
        }
        return checkValidString(s, 0, n, 0);
    }

    public boolean checkValidString(String s, int i, int n, int count) {
        if(i == n) {
            return count == 0;
        }
        if(count < 0) {
            return false;
        }
        if(mem[i][count] != -1) {
            return mem[i][count] == 1;
        }
        boolean res;
        if(s.charAt(i) == '(') {
            res = checkValidString(s, i+1, n, count+1);
        } else if(s.charAt(i) == ')') {
            res = checkValidString(s, i+1, n, count-1);
        } else {
            res = checkValidString(s, i+1, n, count) 
                ||checkValidString(s, i+1, n, count+1) 
                || checkValidString(s, i+1, n, count-1);
        }
        mem[i][count] = res ? 1 : 0;
        return res;
    }

}
