class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) {
            return false;
        }

        int[] s1Arr = new int[26];
        for(int i=0; i<n1; i++) {
            s1Arr[s1.charAt(i) - 'a']++;
        }

        int l=0;
        int r=0;
        int[] s2Arr = new int[26];
        while(r < n2) {
            s2Arr[s2.charAt(r) - 'a']++;
            if(r-l+1 == n1) {
                if(Arrays.equals(s1Arr, s2Arr)) {
                    return true;
                }
                s2Arr[s2.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return false;
    }
}
