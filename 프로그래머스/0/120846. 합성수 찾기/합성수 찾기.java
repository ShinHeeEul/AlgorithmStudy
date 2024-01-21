class Solution {
    static boolean[] isPrime;
    
    static void isPrime_fun(int n){ 
        isPrime = new boolean[n+1];
        for(int i = 0; i < isPrime.length; i++){
            isPrime[i] = true;
        }
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(isPrime[i]) {
                for(int j = i*i; j<= n; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
    
    public int solution(int n) {
        isPrime_fun(n);
        int count = 0;
        for(int i = 0; i <= n; i++) {
            if(!isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}