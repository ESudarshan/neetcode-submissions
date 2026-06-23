class Twitter {

    Map<Integer, Set<Integer>> following;
    Map<Integer, List<int[]>> tweets;
    int timestamp;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();        
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[] {timestamp++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> users = new ArrayList<>();
        users.add(userId);
        if(following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int followeeId : users) {
            if(tweets.containsKey(followeeId)) {
                for(int[] tweet : tweets.get(followeeId)) {
                    minHeap.offer(tweet);
                    if(minHeap.size() > 10) {
                        minHeap.poll();
                    }
                }
            }    
        } 

        List<Integer> tweetIds = new LinkedList<>();
        while(!minHeap.isEmpty()) {
            tweetIds.addFirst(minHeap.poll()[1]);
        }
        
        return tweetIds;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
