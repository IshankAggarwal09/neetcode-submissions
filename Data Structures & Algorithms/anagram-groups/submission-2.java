class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] c = word.toCharArray();
            Arrays.sort(c);
            String sortedWord = new String(c);
            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
