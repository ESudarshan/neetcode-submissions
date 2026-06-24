class Solution {

    Map<Character, List<Character>> map;
    List<String> output = new ArrayList<>();;

    public void init() {
        map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {        
        if(digits == null || digits.isEmpty()) {
            return output;
        }

        init();

        int n = digits.length();
        output.add("");
        for(char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for(String str : output) {
                for(char ch : map.get(digit)) {
                    temp.add(str + ch);
                }
            }
            output = temp;
        }

        return output; 
    }
}
