class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char ch : tasks) {
            map[ch - 'A']++;
        }
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i=0; i<26; i++) {
            if (map[i] > 0) {
                pq.add(map[i]);
            }
        }
        while (!pq.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i=1; i<=n+1; i++) {
                if (!pq.isEmpty()) {
                    int freq = pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }
            for (int f : temp) {
                if (f > 0) {
                    pq.add(f);
                }
            }
            if (pq.isEmpty()) {
                time += temp.size();
            }
            else {
                time += n+1;
            }
        }
        return time;
    }
}