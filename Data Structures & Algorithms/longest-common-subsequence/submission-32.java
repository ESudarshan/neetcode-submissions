class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n+1];
        int diagonal;
        for(int i=m-1; i>=0; i--) {
            diagonal = dp[n];
            for(int j=n-1; j>=0; j--) {
                int temp = dp[j];
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = 1 + diagonal;
                } else {
                    dp[j]= Math.max(dp[j], dp[j+1]);
                }            
                diagonal = temp;
            }    
        }

        return dp[0];
    }

}
