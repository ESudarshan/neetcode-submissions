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

        List<int[]> tweetList = new ArrayList<>();
        for(int followeeId : users) {
            if(tweets.containsKey(followeeId)) {
                for(int[] tweet : tweets.get(followeeId)) {
                    tweetList.add(tweet);
                }
            }    
        } 
        
        Collections.sort(tweetList, (a, b) -> b[0] - a[0]);

        List<Integer> tweetIds = new ArrayList<>();
        for(int i=0; i<tweetList.size(); i++) {
            tweetIds.add(tweetList.get(i)[1]);
            if(tweetIds.size() == 10) {
                break;
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
