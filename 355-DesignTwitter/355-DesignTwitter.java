// Last updated: 22/09/2025, 16:18:46
import java.util.*;

public class Twitter {

    private int timestamp;
    private final Map<Integer, Set<Integer>> follows;
    private final Map<Integer, List<int[]>> tweets;

    public Twitter() {
        timestamp = 0;
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Set<Integer> followees = new HashSet<>(follows.getOrDefault(userId, Collections.emptySet()));
        followees.add(userId);
        for (int u : followees) {
            List<int[]> list = tweets.get(u);
            if (list != null && !list.isEmpty()) {
                int idx = list.size() - 1;
                int[] tw = list.get(idx);
                pq.offer(new int[]{tw[0], tw[1], u, idx});
            }
        }
        while (!pq.isEmpty() && res.size() < 10) {
            int[] cur = pq.poll();
            res.add(cur[1]);
            int u = cur[2];
            int idx = cur[3];
            if (idx - 1 >= 0) {
                int[] prev = tweets.get(u).get(idx - 1);
                pq.offer(new int[]{prev[0], prev[1], u, idx - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> set = follows.get(followerId);
        if (set != null) set.remove(followeeId);
    }
}
