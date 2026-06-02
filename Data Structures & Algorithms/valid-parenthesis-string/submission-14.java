class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int minLeft = 0;
        int maxLeft = 0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(') {
                minLeft++;
                maxLeft++;
            }

            if(s.charAt(i) == ')') {
                minLeft--;
                maxLeft--;
            }

            if(s.charAt(i) == '*') {
                minLeft--;
                maxLeft++;
            }

                        if(minLeft < 0) {
                minLeft = 0;
            }

            if(maxLeft < 0) {
                return false;
            }


        }
        
        return minLeft == 0;
    }
}
