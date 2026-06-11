class Solution {
    private static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // BFS from node 1 to find max depth
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        boolean[] seen = new boolean[n + 1];
        seen[1] = true;
        int depth = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int u = q.poll();
                for (int v : graph[u]) {
                    if (!seen[v]) {
                        seen[v] = true;
                        q.offer(v);
                    }
                }
            }
            depth++;
        }

        // depth = number of levels (including root)
        // edges on path = depth - 1
        // answer = 2^(depth - 2)
        return modPow(2, depth - 2);
    }

    private int modPow(long base, long exp) {
        if (exp <= 0) return 1;
        long result = 1, b = base % MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * b % MOD;
            b = b * b % MOD;
            exp >>= 1;
        }
        return (int) result;
    }
}