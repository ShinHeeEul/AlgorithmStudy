class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 0;
        int tmp = n;
        while(tmp != 0) {
            if(tmp % 2 == 1) count++;
            tmp /= 2;
        }
        int iCount = 0;
        for(int i = n+1;count != iCount; i++) {
            iCount = 0;
            answer = i;
            tmp = i;
            while(tmp != 0) {
                if(tmp % 2 == 1) iCount++;
                tmp /= 2;
            }
        }
        return answer;
    }
}