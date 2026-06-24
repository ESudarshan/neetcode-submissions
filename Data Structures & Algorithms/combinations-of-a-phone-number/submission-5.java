class Solution {

    Map<Character, List<Character>> map;
    List<String> output;

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
        output = new ArrayList<>();
    }

    public List<String> letterCombinations(String digits) {
        init();
        StringBuilder sb = new StringBuilder();
        backtrack(digits, 0, sb);
        return output;
    }

    public void backtrack(String digits, int i, StringBuilder sb) {
        if(i == digits.length()) {
            if(!sb.isEmpty()) {
                output.add(sb.toString());
            }
            return;
        }

        for(Character ch : map.get(digits.charAt(i))) {
            sb.append(ch);
            backtrack(digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}