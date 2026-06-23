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
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if(following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int followeeId : users) {
            if(tweets.containsKey(followeeId) && tweets.get(followeeId).size() > 0) {
                int index = tweets.get(followeeId).size() - 1;
                maxHeap.offer(new int[] {tweets.get(followeeId).get(index)[0], tweets.get(followeeId).get(index)[1], followeeId, index-1});
            }    
        } 

        List<Integer> tweetIds = new ArrayList<>();
        while(!maxHeap.isEmpty() && tweetIds.size() < 10) {
            int[] tweet = maxHeap.poll();
            tweetIds.add(tweet[1]);
            if(tweet[3] != -1) {
                int followeeId = tweet[2];
                int index = tweet[3]; 
                maxHeap.offer(new int[] {tweets.get(followeeId).get(index)[0], tweets.get(followeeId).get(index)[1], followeeId, index-1});
            }
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
