class Twitter {

    Map<Integer, List<Pair<Integer, Integer>>> userIdTweetIdMap;
    Map<Integer, Set<Integer>> userIdFolloweeIdMap;
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
        // return getKMostRecentBySort(userId, 10);
        return getKMostRecentByHeap(userId, 10);
    }
    
    public void follow(int followerId, int followeeId) {
        userIdFolloweeIdMap.putIfAbsent(followerId, new HashSet<>());
        userIdFolloweeIdMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userIdFolloweeIdMap.get(followerId).remove(followeeId);
    }

    List<Integer> getKMostRecentBySort(int userId, int k) {
        List<Pair<Integer, Integer>> tweets = new ArrayList(userIdTweetIdMap.getOrDefault(userId, new ArrayList<>()));
        for(int followeeId : userIdFolloweeIdMap.getOrDefault(userId, new HashSet<>())) {
            tweets.addAll(userIdTweetIdMap.get(followeeId));
        }
        Collections.sort(tweets, (a, b) -> b.getKey() - a.getKey());
        tweets = tweets.size() > k ? tweets.subList(0, k) : tweets;
        return tweets.stream().map(Pair::getValue).distinct().collect(Collectors.toList());
    }

    List<Integer> getKMostRecentByHeap(int userId, int k) {
        Set<Integer> followings = new HashSet<>(userIdFolloweeIdMap.getOrDefault(userId, new HashSet<>()));
        followings.add(userId);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int following : followings) {
            List<Pair<Integer, Integer>> pairList = userIdTweetIdMap.getOrDefault(following, new ArrayList<>());
            if(pairList.size() > 0) {
                int index = pairList.size() - 1;
                maxHeap.offer(new int[] { pairList.get(index).getKey(), pairList.get(index).getValue(), following, index - 1 });
            }
        }
        List<Integer> mr = new ArrayList<>();
        while(!maxHeap.isEmpty() && mr.size() < 10) {
            int[] structure = maxHeap.poll();
            mr.add(structure[1]);
            if(structure[3] != -1) {
                List<Pair<Integer, Integer>> pairList = userIdTweetIdMap.getOrDefault(structure[2], new ArrayList<>());
                maxHeap.offer(new int[] { pairList.get(structure[3]).getKey(), pairList.get(structure[3]).getValue(), structure[2], structure[3] - 1 });
            }
        }
        return mr;
    }

}
