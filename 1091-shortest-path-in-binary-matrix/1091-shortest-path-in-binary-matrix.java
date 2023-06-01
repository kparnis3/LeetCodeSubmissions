class Solution {
    int size;
    int[][] gridS;
    int[][] direct = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1},{-1,1},{1,-1},{-1,-1}}; //Four directions;
    private static class Pair {
        private int intRow;
        private int intCol;

        public Pair(int intRow, int intCol) {
            this.intRow = intRow;
            this.intCol = intCol;
        }

        public int getIntRow() {
            return intRow;
        }

        public int getIntCol() {
            return intCol;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair other = (Pair) obj;
            return intRow == other.intRow && intCol == other.intCol;
        }

        @Override
        public int hashCode() {
            return Objects.hash(intRow, intCol);
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        size = grid.length;
        gridS = Arrays.copyOf(grid, grid.length);
        Set<Pair> visited = new HashSet<>();
        
        return BFS(0,0,visited);
    }
    
    public int BFS(int row, int col, Set<Pair> visit){
        
        if (gridS[row][row]==1){
            return -1;
        }
        
        if (size==1){
            return 1;
        }
        
        int shortestPath = 1;
        Queue<Pair> queue = new LinkedList<>();
        
        queue.offer(new Pair(row,col));
        visit.add(new Pair(row, col));

        while (!queue.isEmpty()) {
            int lenQ = queue.size();
            for(int i=0; i<lenQ; i++){
                Pair currentCord = queue.poll(); //get row and col
                
                int r = currentCord.getIntRow();
                int c = currentCord.getIntCol();
                for (int[] coordinate : direct) {
                    
                    int curR = coordinate[0] + r;
                    int curC = coordinate[1] + c;

                    if(invalid(curR,curC) || visit.contains(new Pair(curR, curC))){ //Invalid 
                        continue; 
                    }
                     
                    if (gridS[curR][curC]==1){
                        continue;
                    }
                    
                    if (curR==size-1 && curC==size-1){
                        shortestPath+=1;
                        return shortestPath;
                    }

                    queue.offer(new Pair(curR, curC));
                    visit.add(new Pair(curR, curC));
                }
            }
            shortestPath+=1;
        }

        return -1;
    }
    
    public boolean invalid(int row, int col){
        return ((row < 0) || (col < 0) || (row == size) || (col==size));
    }
}