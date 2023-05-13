class Solution {

    public boolean divisorGame(int n) {
        
        // Amount of numbers, turn {Alice==1, Bob==0}
        int[][] cache = new int [n+1][2];
        
        // initialise cache to empty
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < 2; j++){
                cache[i][j] = -1;
            }
        }

        if(DivisorDP(n, cache, 1) == 1){
            return true;
        }

        return false;
    }

    //turn: {Alice==1, Bob==0}
    public int DivisorDP(int N, int[][] dp, int Turn)
    {
        //Base cases
        if(N==1 || N==3){ //Bob wins
            return 0; 
        }

        if(N==2){ //Alice wins
            return 1;
        }

        // Already explored
        if (dp[N][Turn] != -1)
        {
            return dp[N][Turn];
        }

        int ans;
        if(Turn==1){ //If Alice's turn still Bob wins
            ans = 0;
        }else{ //If Bob's turn still Alice wise
            ans = 1;
        }

        for(int i=1;i*i<=N;i++){
            if(N % i == 0){
                if(Turn==1){
                    ans |= DivisorDP(N-i, dp, 0);
                }else{
                    ans &= DivisorDP(N-i, dp, 1);
                }
            }
        }

        // set current dp and return
        return dp[N][Turn] = ans;
    }
}