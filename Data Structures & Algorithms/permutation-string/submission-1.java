class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) {
            return false;
        }

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        System.out.println("s1-"+ Arrays.toString(s1Arr));

        int i=0;
        while(i <= n2-n1) { 
            char[] s2Arr = s2.substring(i, i + n1).toCharArray();
            Arrays.sort(s2Arr);

            int index = 0;
            while(index < n1) {
                if(s1Arr[index] != s2Arr[index]) {
                    break;
                }
               index++;
            }

            if(index == n1) {
                return true;
            }
            
            i++;
        }
        return false;
    }
}
