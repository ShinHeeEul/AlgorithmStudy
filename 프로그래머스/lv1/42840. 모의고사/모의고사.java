import java.util.Arrays;

class Solution {
    int[] answer = {};
    public int[] solution(int[] answers) {

        int sum1 = 0, sum2 = 0, sum3 = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == (i%5) + 1)
                sum1 += 1;
            if(answers[i] == method(2,i))
                sum2 += 1;
            if(answers[i] == method(3,i))
                sum3 += 1;
        }
        //System.out.println(sum1+","+ sum2+","+ sum3);
        if(sum1 < sum2) {
            if(sum2 < sum3) append(3);
            else if(sum2 == sum3) {
                append(2);
                append(3);
            }
            else append(2);
        }
        else if(sum1 == sum2) {
            if(sum2 < sum3) append(3);
            else if(sum2 == sum3) {
                append(1);
                append(2);
                append(3);
            }
            else {
                append(1);
                append(2);
            }
        }
        else if(sum1 > sum2) {
            if(sum1 < sum3) append(3);
            else if(sum1 == sum3) {
                
                append(1);
                append(3);
            }
            else append(1);
        }
        
        return answer;
    }
    public void append(int n) {
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[answer.length-1] = n;
    }
    
    public int method(int n, int i) {
        if(n == 2) {
            if(i % 2 == 0)
                return 2;
            else {
                int tmp = i/2 % 4;
                if(tmp == 0) tmp = 1;
                else if(tmp == 1) tmp = 3;
                else if(tmp == 2) tmp = 4;
                else if(tmp == 3) tmp = 5;
                return tmp;
            }
        }
        else {
            int tmp = (i/2) % 5;
            if(tmp == 4) tmp = 5;
            else if(tmp == 3) tmp = 4;
            else if(tmp == 0) tmp = 3;
            return tmp;
        }
    }
}