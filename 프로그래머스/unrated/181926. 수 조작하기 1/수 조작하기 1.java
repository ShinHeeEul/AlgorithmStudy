class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        for(char s : control.toCharArray()) {
            switch(s) {
                case 'w':
                    n++;
                    break;
                case 's':
                    n--;
                    break;
                case 'd':
                    n += 10;
                    break;
                case 'a':
                    n -= 10;
                    break;
            }
            
        }
            return n;
    }
}