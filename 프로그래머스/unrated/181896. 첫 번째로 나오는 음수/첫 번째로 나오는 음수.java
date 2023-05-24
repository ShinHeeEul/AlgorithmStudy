class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum = 0;
        for(int i = 0; i < num_list.length; i++) {
            int sum_tmp = sum;
            sum_tmp += num_list[i];
            if(sum_tmp < sum) return i; 
        }
        return -1;
    }
}