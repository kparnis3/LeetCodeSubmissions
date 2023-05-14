class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        /*
            Preferences Pairs
            Rank: 0     3, 2, 1
                  0 ->  1, 2, 3  [0, 1] [2, 3]
                  1 ->  3, 2, 0
                  2 ->  3, 1, 0
                  3 ->  1, 2, 0
                  
                  FROM
                  0 1 2 3 Rank Matrix   P  M  W HashMap P -> (M, W)
             TO 0 0 3 2 1               0  1  3
                1 1 0 2 3               1  0  1
                2 1 2 0 3               2  3  3
                3 1 3 2 0               3  2  2
        */
        
        //Create Rank array.
        int [][] rankMatrix = new int[preferences.length][preferences[0].length+1];
        int happyPerson = preferences[0].length;
        
        for(int i=0;i< preferences.length ; i++){
            for(int j=0;j<preferences[i].length; j++){
                 rankMatrix[i][preferences[i][j]] = preferences[i].length - j;
            }
        }
        
        // Create HashMap   
        HashMap<Integer, Group> pairList = new HashMap<>();
        
        for(int i = 0; i < pairs.length; i++){
            
            int Person1 = pairs[i][0];
            int Person2 = pairs[i][1];
            
            pairList.put(Person1, new Group(Person2,rankMatrix[Person1][Person2]));
            pairList.put(Person2, new Group(Person1,rankMatrix[Person2][Person1]));
        }
        
        int unhappy = 0;
        HashMap<Integer,Integer> bestMatch = new HashMap<>();
        
        for(Integer Person: pairList.keySet())
        {   
            // If person is happy, skip
            if(pairList.get(Person).weight == happyPerson){
                continue; 
            }
            else{
                // go through prefences and check for an unhappy friend 
                for(int i = 0; i < preferences[0].length; i++)
                {
                    int Person2 = preferences[Person][i];
                    if(rankMatrix[Person][Person2] > pairList.get(Person).weight && 
                       rankMatrix[Person2][Person] > pairList.get(Person2).weight)
                    {
                        unhappy++;
                        break;
                    }
                    
                }
            }
        }
        
        
        return unhappy;
    }
                         
    class Group{
        int person;
        int weight;
        
        Group(int p, int w)
        {
            person=p;
            weight=w;
        }
            
    }
}