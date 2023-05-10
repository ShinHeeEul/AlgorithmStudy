import java.util.*;

class Solution {
    boolean[] check;
    String[] words;
    String target;
    int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 10000;
        this.words = words;
        this.target = target;
        check = new boolean[words.length];
        for(int i = 0; i < words.length; i++) {
            if(canNext(begin, words[i])) {
                dfs(i, 0, 1);
            }   
        }
        
        return answer==10000?0:answer;
    }
    
    public void dfs(int i, int level, int count) {
        if(check[i]) return;
        check[i] = true;
        if(this.target.equals(words[i])) {
            if(answer > count) answer = count;
        }
        
        for(int j = 0; j < words.length; j++) {
            if(canNext(words[i], words[j])) {
                dfs(j, level+1, count+1);
            }   
        }
        check[i] = false;
        
    }
    
    public boolean canNext(String begin, String word) {
        int count = 0;
        char[] beginc = begin.toCharArray();
        char[] wordc = word.toCharArray();
        for(int i = 0; i < begin.length(); i++) {
            if(beginc[i] == wordc[i]) count++;
        }
        if(count == begin.length() - 1) return true;
        return false;
    
    }
}