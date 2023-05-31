class UndergroundSystem {
      
    private static class Pair { // Class to store (StationName, time) pair
        private String stationName;
        private int time;

        public Pair(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }

        public String getStationName() {
            return stationName;
        }

        public int getTime() {
            return time;
        }
    }
    
    private static class stationPair { // Class to store (StartStation, EndStation) pair
        private String stationNameFirst;
        private String stationNameSecond;

        public stationPair(String stationNameFirst, String stationNameSecond) {
            this.stationNameFirst = stationNameFirst;
            this.stationNameSecond = stationNameSecond;
        }

        public String getStationNameFirst() {
            return stationNameFirst;
        }

        public String getStationNameSecond() {
            return stationNameSecond;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            stationPair other = (stationPair) obj;
            return Objects.equals(stationNameFirst, other.stationNameFirst) && Objects.equals(stationNameSecond, other.stationNameSecond);
        }
    

        @Override
        public int hashCode() {
            return Objects.hash(stationNameFirst,  stationNameSecond);
        }
    }
    
    private static class timePair { // Class to store (amount, time) pair used to calculate average
        private int amount;
        private int time;

        public timePair(int amount, int time) {
            this.amount = amount;
            this.time = time;
        }

        public int getAmount() {
            return amount;
        }

        public int getTime() {
            return time;
        }
    }
    
    // ID -> (Start Station Name, Time)
    private Map<Integer, Pair> Store;
    // (StartStation, EndStation) -> (amount, time)
    private Map<stationPair, timePair> Stations;
    
    public UndergroundSystem() { //initialise 
        Store = new HashMap<>();
        Stations = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
         
        Store.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        Pair storedValues = Store.get(id);
        String startStation = storedValues.getStationName();
        int startTime = storedValues.getTime(); 
        
        timePair Result = Stations.get(new stationPair(startStation, stationName));
        if(Result == null) //check if values alread in map
        {
            Stations.put(new stationPair(startStation, stationName), new timePair(0, 0));
            
        }
        
        Result = Stations.get(new stationPair(startStation, stationName));
        int amount = Result.getAmount();
        int time = Result.getTime();      
        Stations.put(new stationPair(startStation, stationName), new timePair(amount+1, time + (t-startTime))); //update values
            
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double averageTime = 0;
        
        timePair Result = Stations.get(new stationPair(startStation, endStation));
            
        int amount = Result.getAmount();
        int time = Result.getTime();  
        
        averageTime = (double) time/amount;
        
        return averageTime;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */