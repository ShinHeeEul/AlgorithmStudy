class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++) {
            String s = quiz[i];
            String[] tmp = s.split(" ");
            int X = Integer.parseInt(tmp[0]);
            String op = tmp[1];
            int Y = Integer.parseInt(tmp[2]);
            int Z = Integer.parseInt(tmp[4]);
            switch(op) {
                case "-":
                    answer[i] = (X-Y==Z)?"O":"X";
                    break;
                case "+":
                    answer[i] = (X+Y==Z)?"O":"X";
                    break;
            }
        }
        
        return answer;
    }
}