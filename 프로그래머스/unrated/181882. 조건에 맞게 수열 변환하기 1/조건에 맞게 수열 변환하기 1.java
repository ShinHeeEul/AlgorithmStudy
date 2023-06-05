class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        for(int i = 0; i < arr.length; i++) {
            int s = arr[i];
            if((s >= 50) && (s % 2 == 0)) arr[i] = s / 2;
            else if((s < 50) && (s % 2 == 1)) arr[i] = s * 2;
        }
        return arr;
    }
}