class Solution {
    public int solution(int[] common) {
        int a = common[1] - common[0];
        int b = common[2] - common[1];
        if(a == b) {
            return common[common.length - 1] + a;
        } else {
            return common[common.length - 1] * (common[1] / common[0]);
        }
    }
}