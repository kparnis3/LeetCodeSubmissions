class Solution {
     static class Edge {
        int source;
        int destination;
        

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination; 
        }   
     }
    
    static class Graph {
        HashMap<Integer, LinkedList<Edge>> adjacencylist;        
        Graph(){
            adjacencylist = new HashMap<>();
        }
        

        public void addEgde(int source, int destination) {
            Edge edge = new Edge(source, destination);
            LinkedList<Edge> edges = adjacencylist.get(source);
            if (edges != null) {
                edges.addFirst(edge); //for directed graph
            }
            else{
                edges.add(edge);
            }
        }
    
        public void addNode(int newNode) {
            if (!adjacencylist.containsKey(newNode)) {
                adjacencylist.put(newNode, new LinkedList<>());
            }
        }

        public void printGraph() {
            for (int vertex : adjacencylist.keySet()) {
                LinkedList<Edge> list = adjacencylist.get(vertex);
                for (Edge edge : list) {
                        System.out.print(vertex + " -> " + edge.destination);
                }
                System.out.println();
            }
        }
        
        public Set<Integer> getVertices(int src) {
            Set<Integer> connectedVertices = new HashSet<>();

            LinkedList<Edge> list = adjacencylist.get(src);
            if (list != null) {
                for (Edge edge : list) {
                    connectedVertices.add(edge.destination);
                }
            }

            return connectedVertices;
        }
    }
    
    public int maximumDetonation(int[][] bombs) {
        
        int result = 0;
        int n = bombs.length;
        Graph graph = new Graph();
        
        //Create directed graph src -> dest
        //This points to which bombs can be deonated
              
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j)
                    continue;
                final long ri = bombs[i][2];
                if (ri * ri >= squaredDist(bombs, i, j)){
                    graph.addNode(i);
                    graph.addEgde(i, j);
                }
            }
        }
        
        Set<Integer> v;
        
        //explore all nodes, get max bombs
        for (int i = 0; i < bombs.length; i++) {
            result = Math.max(result, DFS(graph, i, v = new HashSet<>()));
        }
        
        return result;
    }
    
    public int DFS(Graph g, int src, Set<Integer> visited){
        
        if (visited.contains(src)){ //base case
            return 0;
        }
        
        visited.add(src);
        
        Set<Integer> keySet = g.getVertices(src);

        for (int vertex : keySet) {
            DFS(g,vertex, visited);  
        }

        return visited.size(); //amount visited is maximum bombs that can be detonated
    }
    
    private long squaredDist(int[][] bombs, int i, int j) {
        return (long) (bombs[i][0] - bombs[j][0]) * (bombs[i][0] - bombs[j][0]) +
        (long) (bombs[i][1] - bombs[j][1]) * (bombs[i][1] - bombs[j][1]);
    };
}