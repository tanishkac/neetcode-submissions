class Twitter {
    HashMap<Integer, Set<Integer>> users;
    HashMap<Integer, List<int[]>> tweets;
    int time;

    public Twitter() {
       users = new HashMap<>();
       tweets = new HashMap<>();
       time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        List posts = tweets.getOrDefault(userId, new ArrayList<>());
        int[] post = new int[2];
        post[0] = time;
        post[1] = tweetId;
        posts.add(post);
        tweets.put(userId, posts);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        follow(userId, userId);
        PriorityQueue<int[]> minH = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        Set<Integer> following = users.get(userId);
        for(int f : following) {
            List<int[]> posts = tweets.getOrDefault(f, new ArrayList<>());
            if(!posts.isEmpty()) {
                for(int[] p : posts) {
                if(minH.size() < 10) {
                    minH.add(p);
                }
                else{
                    int[] temp = minH.peek();
                    if(temp[0] < p[0]) {
                        minH.remove();
                        minH.add(p);
                    }
                }
            }
            }
            
        }
        List<Integer> feed = new ArrayList<>();
        
        while(!minH.isEmpty()) {
            int[] pt = minH.remove();
            feed.add(0, pt[1]);
        } 
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        Set following = users.getOrDefault(followerId, new HashSet<>());
        following.add(followeeId);
        users.put(followerId, following);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        } 
        Set following = users.getOrDefault(followerId, new HashSet<>());
        if(!following.isEmpty()) {
            following.remove(followeeId);
            users.put(followerId, following);
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