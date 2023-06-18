class Solution {
    
    int[][] direct = {{0,1}, {0,-1}, {1,0}, {-1,0}}; //Four directions;
    private Map<Pair, Integer> cache = new HashMap<>();
    int mod = 1_000_000_007;
    int[][] gridS;
    int m;
    int n;
    
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
    
    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        gridS = Arrays.copyOf(grid, m);
    
        int answer = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer = (answer + DFS(i, j)) % mod;
            }
        }
        
        return answer % mod;
    
    }
    
    public boolean invalid(int row, int col){
        return ((row < 0) || (col < 0) || (row == m) || (col==n));
    }
    
    public int DFS(int row, int col){
        
        if(cache.containsKey(new Pair(row, col))){
            return cache.get(new Pair(row, col));
        }
        
        int seq = 1;
        
        for (int[] coordinate : direct) {
                    
            int curR = row + coordinate[0];
            int curC = col + coordinate[1];
            
            if(invalid(curR,curC)){ //Invalid 
                continue; 
            }
            
            if(gridS[curR][curC] > gridS[row][col]){
               seq += DFS(curR,curC);
               seq %= mod;
            }
            
            cache.put(new Pair(row, col), seq);
 
        }
        
        return seq;
    }
    
    
}