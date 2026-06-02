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
            if(count == 0) {
                return true;
            }
            return false;
        }
        if(count < 0) {
            return false;
        }
        if(mem[i][count] != -1) {
            return mem[i][count] == 1;
        }
        if(s.charAt(i) == '(') {
            return checkValidString(s, i+1, n, count+1);
        } 
        if(s.charAt(i) == ')') {
            return checkValidString(s, i+1, n, count-1);
        }
        boolean res = checkValidString(s, i+1, n, count) 
                ||checkValidString(s, i+1, n, count+1) 
                || checkValidString(s, i+1, n, count-1);
        mem[i][count] = res ? 1 : 0;
        return res;
    }

}
