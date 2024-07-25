import java.util.*;

class Solution {
    
    int[] ld;
    boolean[][] visited;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int min;
    int max;
    int[][] lands;
    int count;
    public int solution(int[][] land) {
        int answer = 0;
        ld = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];
        lands = new int[land.length][land[0].length];
        
        for(int i = 0; i < land.length; i++) {
            lands[i] = land[i].clone();
        }
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                min = Integer.MAX_VALUE;
                max = 0;
                count = 0;
                if(lands[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(i,j);
                    for(int k = min; k <= max; k++) {
                        ld[k] += count;
                    }
                }
            }
        }
        
        for(int i = 0; i < ld.length; i++) {
            answer = Math.max(ld[i], answer);
        }
        
        return answer;
    }
    
    public void dfs(int i, int j) {
        count++;
        
        lands[i][j] = 0;
        max = Math.max(j, max);
        min = Math.min(j, min);
        for(int t = 0; t < 4; t++) {
            int ii = i + dy[t];
            int jj = j + dx[t];
            if(!check(ii, jj)) continue;
            visited[ii][jj] = true;
            dfs(ii,jj);
        }

        
    }
    
    public boolean check(int i, int j) {
        if(i < 0 || i >= visited.length || j < 0 || j >= visited[0].length) return false;
        if(visited[i][j]) return false;
        if(lands[i][j] != 1) return false;
        return true;
    }
    
}