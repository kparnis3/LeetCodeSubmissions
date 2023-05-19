class Solution {
    public boolean isBipartite(int[][] graph) {      
    /*
        Following is a simple algorithm to find out whether a given graph is Bipartite or not using Breadth First Search (BFS). 
            1. Assign RED color to the source vertex (putting into set U). 
            2. Color all the neighbors with BLUE color (putting into set V). 
            3. Color all neighbor’s neighbor with RED color (putting into set U). 
            4. This way, assign color to all vertices such that it satisfies all the constraints of m way coloring problem where m = 2. 
            5. While assigning colors, if we find a neighbor which is colored with same color as current vertex, then the graph cannot be colored                with 2 vertices (or graph is not Bipartite) 
    
    */
        
    int[] color = new int[graph.length];
    
    for(int i=0; i< graph.length; i++)
    {
        if (color[i] != 0) continue;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(i);
    
        color[i] = 1; // 1 <- RED
        
        while (!queue.isEmpty())
        {
            int n1 = queue.poll();
            for(int v: graph[n1]){
                
                if (color[v] == 0){
                    color[v] = -color[n1];
                    queue.offer(v);
                }
                else if(color[n1]==color[v]){
                    return false;
                }
            }
            
        }

    }

    return true;
    
}

}