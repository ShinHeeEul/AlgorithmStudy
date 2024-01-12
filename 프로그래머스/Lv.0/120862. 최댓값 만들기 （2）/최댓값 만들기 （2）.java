class Solution {
    public int solution(int[] numbers) {
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < numbers.length; i++) {
            int a = numbers[i];
            for(int j = i + 1; j < numbers.length; j++) {
                int b = numbers[j];
                int val = a * b;
                if(max < val) {
                    max = val;
                }
            }
        }
        
        return max;
    }
}