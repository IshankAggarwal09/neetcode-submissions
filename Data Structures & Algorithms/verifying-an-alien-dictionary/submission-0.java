class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> charOrder = new HashMap<>();
        for (int i=0; i<order.length(); i++) {
            charOrder.put(order.charAt(i), i);
        }
        for (int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.min(word1.length(), word2.length());
            for (int j=0; j<len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (charOrder.get(word1.charAt(j)) > charOrder.get(word2.charAt(j))) {
                        return false;
                    }
                    else {
                        break;
                    }
                }
            }
            if (word1.length() > word2.length() && word1.substring(0, word2.length()).equals(word2)) {
                return false;
            }
        }
        return true;
    }
}