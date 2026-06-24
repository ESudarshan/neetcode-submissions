class Solution {

    Map<Character, List<Character>> map;
    LinkedList<String> output = new LinkedList<>();;

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
        for(int i=0; i<n; i++) {
            char digit = digits.charAt(i);
            while(!output.isEmpty() && output.peek().length() == i) {
                String str = output.remove();
                for(char ch : map.get(digit)) {
                    output.add(str + ch);
                }
            }
        }

        return output; 
    }
}
