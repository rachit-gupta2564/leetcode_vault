// Last updated: 22/09/2025, 16:19:17
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", map, res);
        return res;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> pq = map.get(airport);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), map, res);
        }
        res.addFirst(airport);
    }
}
