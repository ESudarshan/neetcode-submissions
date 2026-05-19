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
        return getKMostRecent(tweets, 10);
    }
    
    public void follow(int followerId, int followeeId) {
        userIdFolloweeIdMap.putIfAbsent(followerId, new ArrayList<>());
        if(!userIdFolloweeIdMap.get(followerId).contains(followeeId)) {
            userIdFolloweeIdMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        userIdFolloweeIdMap.get(followerId).removeIf(f -> f == followeeId);
    }

    List<Integer> getKMostRecent(List<Pair<Integer, Integer>> tweets, int k) {
/*
        Collections.sort(tweets, (a, b) -> b.getKey() - a.getKey());
        tweets = tweets.size() > k ? tweets.subList(0, k) : tweets;
        return tweets.stream().map(Pair::getValue).distinct().collect(Collectors.toList());
*/
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        for(Pair<Integer, Integer> tweet : tweets) {
            minHeap.offer(tweet);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> mr = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            int tweetId = minHeap.poll().getValue();
            if(!mr.contains(tweetId)) {
                mr.add(0, tweetId);
            }
        }
        return mr;
    }

}
