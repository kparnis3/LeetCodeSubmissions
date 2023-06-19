class Solution {
    int MOD = 1_000_000_007;
    
    public int numOfWays(int[] nums) {
        /* [2,1,3] and [2,3,1] both form:
                    2
                   / \
                  1   3
           STEPS:
           
           1. Fix root node
           2. All elements less than root -> L
              All elements higher than root -> R
           3. Permutation & Combinations: nChooseR * ways(L) * ways(R)
           
        */
        
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        return (ways(list) - 1) % MOD;
    }
    
    public int ways(List<Integer> nums){
        if(nums.size() <= 2){
            return 1;
        }
        
        List<Integer> arrR = new ArrayList<>();
        List<Integer> arrL = new ArrayList<>();
        int root = nums.get(0);
        
        for (int i = 1; i < nums.size(); i++) {
            int n = nums.get(i);
            if (n > root) {
                arrR.add(n);
            } else {
                arrL.add(n);
            }
        }
        
        int n = arrR.size() + arrL.size();
        int r = arrR.size();
        
        //long ans = fact(n) / (fact(r) * fact(n-r));
        long ans = 1;
        ans = (ans * nChooseR(n, r)) % MOD;
        ans = (ans * ways(arrR)) % MOD;
        ans = (ans * ways(arrL)) % MOD;
        return (int) ans;
        
    }
    
    public long nChooseR(int n, int r) {
        long num = 1;
        long den = 1;

        for (int i = 1; i <= r; i++) {
            num = (num * (n - i + 1)) % MOD;
            den = (den * i) % MOD;
        }

        long invDen = modInv(den);
        return (num * invDen) % MOD;
    }

    public long modInv(long n) {
        return pow(n, MOD - 2);
    }

    public long pow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }

        return result;
    }
}