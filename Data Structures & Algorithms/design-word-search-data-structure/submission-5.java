class WordDictionary {

    List<String> store;

    public WordDictionary() {
        store = new ArrayList<>();
    }

    public void addWord(String word) {
        store.add(word);
    }

    public boolean search(String word) {
        for(String str : store) {
            if(str.length() != word.length()) {
                continue;
            }
            int i=0;
            while(i < word.length()) {
                char wCh = word.charAt(i);
                char sCh = str.charAt(i);
                if(wCh == '.' || wCh == sCh) {
                    i++;
                } else {
                    break;
                }
            }
            if(i == word.length()) {
                return true;
            }
        }
        return false;
    }
}
