class Solution{
    int size;
    int[][] gridS;
    int[][] direct = {{0,1}, {0,-1}, {1,0}, {-1,0}}; //Four directions;
    
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
    
    public int shortestBridge(int[][] grid) {
        /*  
            Example 1:
            
                    01      Level: 0
                    10    
                   /  \  
                v 11  01 v  Level: 1
                  10  11
                  |   |
                v 11  11 v  Level: 2
                  11  11
                  
            Example 1:
            
                     010      Level: 0
                     000
                     001  
                  /   |   \
              x  110 011 x 010 x Level: 1
              x  000 000 x 010 x
              x  001 001 x 001 x 
        */
        
        size = grid.length;
        gridS = Arrays.copyOf(grid, grid.length);
        Set<Pair> visited = new HashSet<>();
        int res = searchIsland(visited);
        
        return res;
    }

    public int searchIsland(Set<Pair> visit){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(gridS[i][j]==1){
                    DFS(i,j,visit); //Finds all 1's part of the first island and ads
                    return BFS(i,j,visit);
                }
            }
        }
        return -1; // no island found
    }
    
    public boolean invalid(int row, int col){
        return ((row < 0) || (col < 0) || (row == size) || (col==size));
    }
    
    public int BFS(int row, int col, Set<Pair> visit){

        int result = 0;
        Queue<Pair> queue = new LinkedList<>();

        for (Pair pair : visit) {
            queue.offer(new Pair(pair.getIntRow(), pair.getIntCol()));
        }

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
                        return result;
                    }

                    queue.offer(new Pair(curR, curC));
                    visit.add(new Pair(curR, curC));
                }
            }
            result+=1;
        }

        return result;
    }

    public void DFS(int row, int col, Set<Pair> visit){
        
        if((invalid(row,col)) || (gridS[row][col]==0) || visit.contains(new Pair(row, col))){ //Invalid or Water
            return; 
        }

        visit.add(new Pair(row, col));
        for (int[] coordinate : direct) {
            int dr = coordinate[0];
            int dc = coordinate[1];

            DFS(row + dr, col+dc, visit);
        }
    }
    
}