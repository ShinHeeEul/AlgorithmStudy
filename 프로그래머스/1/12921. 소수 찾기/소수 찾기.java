class Solution {
    static boolean[] isPrime;
    public int solution(int n) {
        int answer = 0;
        isPrime_fun(n);
        for(boolean b : isPrime) {
            if(b) answer++;
        }
        return answer;
    }
    
    
    static void isPrime_fun(int n){ 
        isPrime = new boolean[n+1];    
        for(int i = 0; i < isPrime.length; i++){
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(isPrime[i]){
                for(int j = i*i; j<= n; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
}