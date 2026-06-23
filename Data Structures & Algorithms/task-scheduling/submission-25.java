class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }

        int maxFreq = 0;
        for(int c : count) {
            maxFreq = Math.max(maxFreq, c);
        }

        int maxFreqCount = 0;
        for(int i=0; i<26; i++) {
            if(count[i] == maxFreq) {
                maxFreqCount++;
            }
        }

        return Math.max(tasks.length, ((maxFreq - 1) * (n + 1)) + maxFreqCount);
    }
}
