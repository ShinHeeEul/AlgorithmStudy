import java.math.*;
    
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        int[] counts = new int[number + 1];
        counts[1] = 1;
        for(int i = 2; i <= number;i++) {
            counts[i] = cd(i);
            if(counts[i] > limit) {
                counts[i] = power;
            }
            answer += counts[i]; 
        }
        
        
        return answer;
    }
    
    public int cd(int num) {
        int count = 0;
        
        int sqrt = (int) Math.sqrt(num);
        for(int i = 1; i <= sqrt; i++) {
            if(num % i == 0) {
                count++;
            }
            
        }
        
        
        if(sqrt == Math.sqrt(num)) return count * 2 - 1;
        
        return count * 2;
    }
}