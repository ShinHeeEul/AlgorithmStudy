class Solution {
    int[][] dungeons;
    int answer = 0;
    boolean[] check;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        check = new boolean[dungeons.length];
        
        
        for(int i = 0; i < dungeons.length; i++) {
            find(i, k, 0, 0);
        }
        return answer;
    }
    
    public void find(int current, int k, int count, int sum) {
        check[current] = true;
        if((k - dungeons[current][0]) >= 0) {
            k = k - dungeons[current][1];
            sum++;
        }
        if(count == dungeons.length - 1) {
            if(sum > answer) answer = sum;
            check[current] = false;
            return;
        }
        for(int i = 0; i < check.length; i++) {
            if(!check[i]) find(i, k, count+1, sum);
        }
        check[current] = false;
    }
}