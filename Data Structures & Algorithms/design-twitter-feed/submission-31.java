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

        List<int[]> feed = new ArrayList<>();
        for(int followeeId : users) {
            if(tweets.containsKey(followeeId)) {
                feed.addAll(tweets.get(followeeId));    
            }    
        } 
        Collections.sort(feed, (a, b) -> b[0] - a[0]);

        List<Integer> tweetIds = new ArrayList<>();
        int t = 0;
        for(int[] tweet : feed) {
            tweetIds.add(tweet[1]);
            t++;
            if(t == 10) {
                break;
            }
        }
        
        return tweetIds;
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
