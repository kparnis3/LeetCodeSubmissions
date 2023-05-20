class Solution {
 

    static class Edge {
        String source;
        String destination;
        double weight;

        public Edge(String source, String destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
            }   
    }
    
    private static class Pair {
        private String stringValue;
        private double doubleValue;

        public Pair(String stringValue, double doubleValue) {
            this.stringValue = stringValue;
            this.doubleValue = doubleValue;
        }

        public String getStringValue() {
            return stringValue;
        }

        public double getDoubleValue() {
            return doubleValue;
        }
    }

    static class Graph {
        HashMap<String, LinkedList<Edge>> adjacencylist;
        
        Graph(Set<String> varSet) {
            adjacencylist = new HashMap<>();
            //initialize adjacency lists for all the vertices
            for (String set: varSet){
                adjacencylist.put(String.valueOf(set), new LinkedList<>());
            }
        }

        public void addEgde(String source, String destination, double weight) {
            Edge edge = new Edge(source, destination, weight);
            LinkedList<Edge> edges = adjacencylist.get(source);
            if (edges != null) {
                edges.addFirst(edge); //for directed graph
            }
            else{
                edges.add(edge);
            }
        }

        public void printGraph() {
            for (String vertex : adjacencylist.keySet()) {
                LinkedList<Edge> list = adjacencylist.get(vertex);
                for (Edge edge : list) {
                    System.out.print(vertex + " -> " +
                            edge.destination + ", w: " + edge.weight + ". ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
        public double bfs(String startVertex, String targetVertex) {
            if (!adjacencylist.containsKey(startVertex)) { // Start Vertex isnt in list
                return -1;
            }

            Set<String> visited = new HashSet<>();
            Queue<Pair> queue = new LinkedList<>();

            visited.add(startVertex); //add to visited
            queue.offer(new Pair(startVertex, 1)); //add to queue

            while (!queue.isEmpty()) {
                
                Pair currentVertex = queue.poll(); //get curr vert
                
                String val = currentVertex.getStringValue();
                double weight = currentVertex.getDoubleValue();
                if (val.equals(targetVertex)) {
                    return weight; // Found the target vertex, return the multiplication
                }

                LinkedList<Edge> edges = adjacencylist.get(val);
                if (edges != null) {
                    for (Edge edge : edges) {
                        String destination = edge.destination;
                        if (!visited.contains(destination)) {
                            visited.add(destination);
                            queue.offer(new Pair(destination, weight * edge.weight));
                        }
                    }
                }
            }

            return -1; // Target vertex not found
        }
    }
    
  
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
            Form a weighted graph Numerator -> Denominator
                                            <-
            Example 1: 
                [a,b] = 2.0
                [b,c] = 3.0
                
                a -> b -> c   
                  2    3
                a <- b <- c
                  1/2  1/3
            
            From graph: [a,c] = 2 * 3
                        [b,a] = 1/2
                        [a,e] = ? : -1
                        [a/a] = Always 1 (if in graph)
                        [x/x] = ? : -1
        */
        
        Set<String> varSet = new HashSet<String>();
        
        //create a set of all end sets
        for (List<String> eq: equations) {
            varSet.add(eq.get(0));
            varSet.add(eq.get(1));
        }

        Graph graph = new Graph(varSet);
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            
            graph.addEgde(a, b, values[i]);
            graph.addEgde(b, a, 1 / values[i]);
        }
        
        // graph.printGraph();
        
        double[] result = new double[queries.size()];
        int j = 0;
         
        for(List<String> que: queries){
            
            result[j] = DFS(graph, que.get(0), que.get(1));
            j++;
        }
        
   
        return result;
    }
    
    public double DFS(Graph g, String src, String trg){
        
        double found = g.bfs(src, trg);
        
        if (found!=-1 && !src.equals(trg)) {
            return found;
        } 
        else if(found!=-1 && src.equals(trg)){
            return 1;
        }
        else{
            return -1;
        }
    }

      
}