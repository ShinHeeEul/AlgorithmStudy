class Solution {
    public int[] solution(int[] array) {
        int max = 0;
        int maxI = -1;
        for(int i = 0; i < array.length; i++) {
            int arr = array[i];
            if(max < arr) {
                max = arr;
                maxI = i;
            }
        }
        return new int[] {max, maxI};
    }
}