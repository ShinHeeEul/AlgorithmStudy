import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        PriorityQueue<Student> queue = new PriorityQueue<>();
        for(int i = 0; i < rank.length; i++) {
            queue.add(new Student(i, rank[i], attendance[i]));
        }
        
        int pick = 1;
        while(pick != 4) {
            Student student = queue.poll();
            if(student.attendance) {
                answer += (student.i * Math.pow(10,6 - pick * 2));
                pick++;
            }
        }
        return answer;
    }
    
    static class Student implements Comparable<Student> {
        int i;
        int rank;
        boolean attendance;
        
        public Student(int i, int rank, boolean attendance) {
            this.i = i;
            this.rank = rank;
            this.attendance = attendance;
        }
        
        @Override
        public int compareTo(Student s) {
            return this.rank - s.rank;
        }
    }
}