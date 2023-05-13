class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        char[] carr = my_string.toCharArray();
        for(int[] arr : queries) {
            for(int i = arr[0]; i <= arr[0] + ((arr[1] - arr[0]) / 2); i++) {
                char tmp = carr[i];
                carr[i] = carr[arr[1] + arr[0] - i];
                carr[arr[1] + arr[0] - i] = tmp;
            }
        }
        
        return new String(carr);
    }
}