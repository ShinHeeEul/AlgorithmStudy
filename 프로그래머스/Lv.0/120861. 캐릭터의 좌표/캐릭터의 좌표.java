class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        int xSize = board[0] / 2;
        int ySize = board[1] / 2;
        for(String s : keyinput) {
            switch(s) {
                case "left":
                    if(x != -xSize) {
                        x--;
                    }
                    break;
                case "right":
                    if(x != xSize) {
                        x++;
                    }
                    break;
                case "up":
                    if(y != ySize) {
                        y++;
                    }
                    break;
                case "down":
                    if(y != -ySize) {
                        y--;
                    }
                    break;
            }
        }
        
            return new int[] {x, y};
    }
}