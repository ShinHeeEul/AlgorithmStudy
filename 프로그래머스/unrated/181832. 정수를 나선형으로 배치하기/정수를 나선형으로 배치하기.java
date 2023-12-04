class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int a = 0;
        int k = 0;
        int x = -1;
        int y = 0;

        for(int m = 0; m < (2 * n - 1); m++) {
            while(true) {
                int beforeX = x;
                int beforeY = y;
                switch(k) {
                    case 0:
                        x++;
                        break;
                    case 1:
                        y++;
                        break;
                    case 2:
                        x--;
                        break;
                    case 3:
                        y--;
                        break;
                }
                if(y >= n || x >= n || y < 0 || x < 0 || answer[y][x] != 0) {
                    x = beforeX;
                    y = beforeY;
                    break;
                }
                answer[y][x] = ++a;
            }
            switch(k) {
                case 0:
                    k = 1;
                    break;
                case 1:
                    k = 2;
                    break;
                case 2:
                    k = 3;
                    break;
                case 3:
                    k = 0;
                    break;
            }
        }

        return answer;
    }
}