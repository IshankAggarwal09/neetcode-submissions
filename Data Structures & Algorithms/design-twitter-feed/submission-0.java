class Twitter {

    private int time = 0;
    private Map<Integer, Set<Integer>> followMap = new HashMap<>();
    private Map<Integer, List<int[]>> tweetMap = new HashMap<>();
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{tweetId, time++});
    }
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> allTweets = new ArrayList<>();
        if (tweetMap.containsKey(userId)) {
            allTweets.addAll(tweetMap.get(userId));
        }
        if (followMap.containsKey(userId)) {
            for (int followeeId : followMap.get(userId)) {
                if (tweetMap.containsKey(followeeId)) {
                    allTweets.addAll(tweetMap.get(followeeId));
                }
            }
        }
        allTweets.sort((a, b) -> b[1] - a[1]);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            res.add(allTweets.get(i)[0]);
        }
        return res;
    }
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */