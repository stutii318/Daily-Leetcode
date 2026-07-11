import java.util.*;
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] vertexCount = {0};
                int[] edgeCount = {0};
                dfs(i, adj, visited, vertexCount, edgeCount);
                int V = vertexCount[0];
                int E = edgeCount[0] / 2;
                if (E == (V * (V - 1)) / 2) {
                    completeComponentsCount++;
                }
            }
        }
        return completeComponentsCount;
    }
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] vertexCount, int[] edgeCount) {
        visited[node] = true;
        vertexCount[0]++;
        edgeCount[0] += adj.get(node).size(); 

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, vertexCount, edgeCount);
            }
        }
    }
}