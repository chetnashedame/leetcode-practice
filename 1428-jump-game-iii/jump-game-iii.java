class Solution {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start, new boolean[arr.length]);
    }

    private boolean dfs(int[] arr, int i, boolean[] visited) {
        // out of bounds or already visited
        if (i < 0 || i >= arr.length || visited[i]) return false;

        // found 0
        if (arr[i] == 0) return true;

        visited[i] = true;

        // explore both directions
        return dfs(arr, i + arr[i], visited) ||
               dfs(arr, i - arr[i], visited);
    }
}
