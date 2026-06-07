class Post {
    int i;
    int t;
    Post(int i, int t) {
        this.i = i;
        this.t = t;
    }
}
class Twitter {

    Map<Integer, List<Post>> userPosts;
    Map<Integer, List<Integer>> userFollowings;
    int t = 1;
    public Twitter() {
        userPosts = new HashMap<>();
        userFollowings = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userPosts.putIfAbsent(userId, new ArrayList<>());
        Post p = new Post(tweetId, t);
        t++;
        userPosts.get(userId).add(p);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followings = userFollowings.getOrDefault(userId, new ArrayList<>());
        List<Post> posts = new ArrayList<>();
        for (int f: followings) {
            posts.addAll(userPosts.getOrDefault(f, new ArrayList<>()));
        }
        posts.addAll(userPosts.getOrDefault(userId, new ArrayList<>()));
        PriorityQueue<Post> pq = new PriorityQueue<>(
            Comparator.comparingInt(p -> p.t)
        );
        for (Post p: posts) {
            pq.add(p);
            if (pq.size() > 10) {
                pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().i);
        }
        Collections.reverse(ans);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        userFollowings.putIfAbsent(followerId, new ArrayList<>());
        if (userFollowings.get(followerId).contains(followeeId)) {
            return;
        }
        userFollowings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowings.putIfAbsent(followerId, new ArrayList<>());
        userFollowings.get(followerId).remove(Integer.valueOf(followeeId));
    }
}
