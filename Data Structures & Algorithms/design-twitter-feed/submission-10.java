class Twitter {

    Map<Integer, List<Pair<Integer, Integer>>> userIdTweetIdMap;
    Map<Integer, List<Integer>> userIdFolloweeIdMap;
    int timestamp;

    public Twitter() {
        userIdTweetIdMap = new HashMap<>();
        userIdFolloweeIdMap = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        userIdTweetIdMap.putIfAbsent(userId, new ArrayList<>());
        userIdTweetIdMap.get(userId).add(new Pair(timestamp, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Pair<Integer, Integer>> tweets = new ArrayList(userIdTweetIdMap.getOrDefault(userId, new ArrayList<>()));
        for(int followeeId : userIdFolloweeIdMap.getOrDefault(userId, new ArrayList<>())) {
            tweets.addAll(userIdTweetIdMap.get(followeeId));
        }
        Collections.sort(tweets, (a, b) -> b.getKey() - a.getKey());
        tweets = tweets.size() > 10 ? tweets.subList(0, 10) : tweets;
        return tweets.stream().map(Pair::getValue).distinct().collect(Collectors.toList());
    }
    
    public void follow(int followerId, int followeeId) {
        userIdFolloweeIdMap.putIfAbsent(followerId, new ArrayList<>());
        userIdFolloweeIdMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userIdFolloweeIdMap.get(followerId).removeIf(f -> f == followeeId);
    }
}
