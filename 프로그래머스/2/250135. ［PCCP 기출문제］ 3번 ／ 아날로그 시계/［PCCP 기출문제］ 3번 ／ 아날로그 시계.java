class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        long hourDegree = 833;
        long minDegree = 10000;
        long secondDegree = 600000;
        
        long startHourDegree = hourDegree * (h1 * 3600 + m1 * 60 + s1) % 36000000;
        long startMinDegree = minDegree * (m1 * 60 + s1) % 36000000;
        long startSecondDegree = secondDegree * s1 % 36000000;
        
        int count = (h2 - h1) * 3600 + (m2 - m1) * 60 + s2 - s1;

        if((startHourDegree == 0 || startHourDegree == 35985600) && startMinDegree == 0 && startSecondDegree == 0) {
                startHourDegree = 0;
                answer++;
            }
        long beforeHourDegree = startHourDegree;
        long beforeMinDegree = startMinDegree;
        long beforeSecondDegree = startSecondDegree;
        
        int let = 0;
        while(count != 0) {
            boolean b = true;
            count--;
            
            if((startHourDegree == 0 || startHourDegree == 35985600) && startMinDegree == 0 && startSecondDegree == 0) {
                startHourDegree = 0;
                b = false;
            }
            
            if((startHourDegree == 0 || startHourDegree == 35984767) && startMinDegree == 35990000 && startSecondDegree == 35400000) {
                System.out.println("dfs");
            }
            
            if(let== 0) {
                System.out.println("21second : " + startSecondDegree + " min : " + startMinDegree +  " erere : " + startHourDegree);
            }

                
            
            let++;
            
            startHourDegree = (startHourDegree + hourDegree)  % 36000000;
            startMinDegree = (startMinDegree + minDegree) % 36000000;
            startSecondDegree = (startSecondDegree + secondDegree) % 36000000;
            
            
            if(b) {
            
            if((startSecondDegree == 0 && startMinDegree > 35400000) ||
              (startSecondDegree == 0 && startHourDegree > 35400000)){
                System.out.println("aaab");
                answer++;
            } else { 
                if(beforeMinDegree > beforeSecondDegree &&
              startMinDegree <= startSecondDegree) {
                System.out.println("aaac");
                answer++;
            }
            if(beforeHourDegree > beforeSecondDegree &&
               startHourDegree <= startSecondDegree) {
                System.out.println("aaad");
                answer++;
            }
                   }
            }
            
            if(startHourDegree == 35985600) startHourDegree = 0;
            beforeHourDegree = startHourDegree;
            beforeMinDegree = startMinDegree;
            beforeSecondDegree = startSecondDegree;
            
        }
        
        return answer;
    }
}