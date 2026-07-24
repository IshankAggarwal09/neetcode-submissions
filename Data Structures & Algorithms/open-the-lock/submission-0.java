class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendSet.contains("0000")) {
            return -1;
        }
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>("0000", 0));
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        while (!q.isEmpty()) {
            Pair<String, Integer> curr = q.poll();
            String currCombination = curr.getKey();
            int moves = curr.getValue();
            if (currCombination.equals(target)) {
                return moves;
            }
            for (int i=0; i<4; i++) {
                for (int delta : new int[]{-1, 1}) {
                    int newDigit = (currCombination.charAt(i) - '0' + delta + 10) % 10;
                    String newCombination = currCombination.substring(0, i) + newDigit + currCombination.substring(i+1);
                    if (!visited.contains(newCombination) && !deadendSet.contains(newCombination)) {
                        visited.add(newCombination);
                        q.add(new Pair<>(newCombination, moves+1));
                    }
                }
            }
        }
        return -1;
    }
}