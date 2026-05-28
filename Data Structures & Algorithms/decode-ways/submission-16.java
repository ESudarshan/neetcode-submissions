class Solution {

    int[] mem;

    public int numDecodings(String s) {
        int n = s.length();
        mem = new int[n];
        Arrays.fill(mem, -1);
        return decode(s, 0, n);
    }

    public int decode(String s, int i, int n) {
        if(i == n) {
            return 1;
        }
        if(mem[i] != -1) {
            return mem[i];
        }
        if(s.charAt(i) == '0') {
            return 0;
        }
        int res = decode(s, i + 1, n);
        if(isValid2DNumber(s, i, n)) {
            res += decode(s, i + 2, n);
        }
        mem[i] = res;
        return mem[i];
    }

    public boolean isValid2DNumber(String s, int i, int n) {
        return (i + 1) <= n - 1 
                && (s.charAt(i) == '1' 
                    || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'));
    }

}
