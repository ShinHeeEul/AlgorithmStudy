class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(check(board, i, j)) {
                   answer++; 
                }
            }
        }
        return answer;
    }
    
    public boolean check(int[][] board, int i, int j) {
        if(board[i][j] == 1) {
            return false;
        }
        if(i != 0) {
            if(board[i-1][j] == 1) {
                return false;
            } 
            if(j != board[0].length-1) {
            if(board[i-1][j+1] == 1) {
                return false;
            }
        }
        } 
        if(i != board.length-1) {
            if(board[i + 1][j] == 1) {
                return false;
            }
            if(j != 0) {
            if(board[i + 1][j-1] == 1) {
                return false;
            }
        }
        }
        if(j != 0) {
            if(board[i][j - 1] == 1) {
                return false;
            }
            if(i != 0) {
                if(board[i - 1][j - 1] == 1) {
                    return false;
                }
            }
        } 
        if(j != board[0].length-1) {
            if(board[i][j + 1] == 1) {
                return false;
            }
            if(i != board.length-1) {
                if(board[i + 1][j + 1] == 1) {
                    return false;
                }
            }
        } 
        return true;
    }
}