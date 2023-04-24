import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap <String, Integer> genre_play = new HashMap<>();
        List<Sum> all = new LinkedList();
        
        for(int i = 0; i < genres.length; i++) {
            Sum sum = new Sum(genres[i], plays[i], i);
            all.add(sum);
            //genre 별로 횟수 정리
            if(genre_play.containsKey(genres[i])) 
                genre_play.put(genres[i], genre_play.get(genres[i]) + plays[i]);
            else
                genre_play.put(genres[i], plays[i]);
            
        }
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(genre_play.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for(Map.Entry<String, Integer> entry : entryList) {
            Sum[] play_size = {new Sum("",0,-1),
                               new Sum("",0,-1)}; 
            for(Sum s : all) {
                if(s.genre.equals(entry.getKey())) {
                    //System.out.println(s);
                    if(play_size[1].play < s.play) {
                        if(play_size[0].play < s.play)  {play_size[1] = play_size[0]; play_size[0] = s;}
                        else play_size[1] = s;
                    }
                }
            }
            if(play_size[0].number != -1) answer.add(play_size[0].number);
            
            if(play_size[1].number != -1) answer.add(play_size[1].number);
        }
        
            
        return answer;
    }
    class Sum{
        public String genre;
        public int play;
        public int number;
        public Sum(String a, int b, int c) {genre = a; play = b; number = c;}
        
        @Override
        public String toString() {
            return "genre : " + genre + ", play : " + play + ", number : " + number;
        }
    }
}