class Solution {
    public int findCircleNum(int[][] isConnected) { //By BFS
        int n = isConnected.length;
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            
            visited.add(i);
            queue.add(i);
            
            while (!queue.isEmpty()) {
                int node = queue.poll();
                
                for (int j = 0; j < n; j++) {
                    if (isConnected[node][j] == 1 && !visited.contains(j)) { //if directly connected and visited
                        visited.add(j); 
                        queue.add(j);
                    }    
                }
            }
            
            result++;
        }
        
        return result;
    }
}