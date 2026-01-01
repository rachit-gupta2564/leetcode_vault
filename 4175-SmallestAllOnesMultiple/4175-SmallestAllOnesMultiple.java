// Last updated: 01/01/2026, 18:32:09
class Solution {
    public int minAllOneMultiple(int k) {
        if(k % 2 ==0 || k % 5 ==0) {
            return -1;
        }
        long mod = 9L * k;
        long ph = phi(mod);
        long o = ph;
        long x = ph;
        for(long p = 2; p * p <= x; p ++) {
            if(x % p == 0) {
                while(x % p == 0) {
                    x /= p;
                }
                while(o % p == 0 && powMod(10, o/p, mod) == 1) {
                    o /= p;
                }
            }
        }
        if(x > 1) {
            long p = x;
            while(o % p == 0 && powMod(10, o/p, mod) == 1) {
                o /= p;
            }
        }
        if(o > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)o;
    }
    public long phi(long n) {
        long res = n;
        long x = n;
        for(long p = 2; p * p <= x; p ++) {
            if(x%p == 0) {
                while(x%p == 0){
                    x /= p;
                }
                res -= res/p;
            }
        }
        if(x > 1) {
            res -= res/x;
        }
        return res;
    }
    public long powMod(long a, long e, long mod) {
        long res = 1 % mod;
        long base = a % mod;
        while(e > 0) {
            if((e & 1) == 1) {
               res = (res * base) % mod; 
            }
            base = (base * base) % mod;
            e >>=1;
        }
        return res; 
    }
}