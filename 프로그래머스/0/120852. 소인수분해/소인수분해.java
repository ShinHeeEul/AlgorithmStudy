import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = true;
        
        for(int i=2; i*i<=n; i++){
            if(!prime[i]){
            	for(int j=i*i; j<=n; j+=i) prime[j] = true;                
            }        
        }    
        
        for(int i = 2; i <= n; i++) {
            if(!prime[i] && n % i == 0) {
               list.add(i); 
            }
        }
        return list;
    }
}