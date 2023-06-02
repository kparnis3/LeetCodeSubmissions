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
        Graph graph = new Graph();
        
        //Create directed graph src -> dest
        //This points to which bombs can be deonated
        
        for(int i = 0; i<bombs.length; i++){
            double x1 = bombs[i][0];
            double y1 = bombs[i][1];
            double r1 = bombs[i][2];
                
            for(int j = i+1; j<bombs.length; j++){               
                double x2 = bombs[j][0];
                double y2 = bombs[j][1];
                double r2 = bombs[j][2];
                
                double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
                
                if(distance <= r1){
                    graph.addNode(i);
                    graph.addEgde(i, j);
                }
                
                if(distance <= r2){
                    graph.addNode(j);
                    graph.addEgde(j, i);
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
}