
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
For example:
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
Hint:
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together inedges.
Understand the problem:
A classic graph search problem. The key is first to transform from the edge list to the adjecent list. The problem is equivalent to whether the graph exists a circle. We could solve the problem by using either DFS or BFS. 

public class Solution {
    public boolean validTree(int n, int[][] edges) {
         
        // Create an adj list 
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
         
        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
            adjList.get(edge[0]).add(edge[1]);
        }
         
        boolean[] visited = new boolean[n];
         
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
         
        while (!queue.isEmpty()) {
            int vertexId = queue.poll();
             
            if (visited[vertexId]) {
                return false;
            }
             
            visited[vertexId] = true;
             
            for (int neighbor : adjList.get(vertexId)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
        }
         
        // Check the islands
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
         
        return true;
    }
}
