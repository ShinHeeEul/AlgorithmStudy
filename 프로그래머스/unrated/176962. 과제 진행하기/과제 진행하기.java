import java.util.*;
class Solution {
    String currentTime = "23:59";
    
    boolean nextDay = false;
    public ArrayList solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        //Map에 담기
        HashMap<String, String[]> map = new HashMap<>();
        
        for(int i = 0; i < plans.length; i++) {
            String[] S = {plans[i][0], plans[i][2]};
            if(FirstTime(plans[i][1])) currentTime = plans[i][1];
            map.put(plans[i][1], S);
        }
        //진행중이던 과제함
        Stack<String> stack = new Stack<>();
        
        int Size = plans.length;
        int i = 1;
        //시작 시간
        String currentStart = currentTime;
        String[] currentSub = map.get(currentStart);
        //map에서 값이 있나 체크하고
        //있으면 stack에 넣고 해당 과제 시작
        //없으면 과제 시간 끝날 때까지 continue;
        while(answer.size() != Size) {
            //시간 경과
            currentTime = getTime(i);
            //경과시간 1 지나게 하고 
            int restTime = Integer.parseInt(currentSub[1]) - i;
            currentSub[1] = restTime + "";
            map.put(currentStart, currentSub);
            //답지에 추가하고
                if(restTime == 0) {
                    answer.add(currentSub[0]);
                }
                if(restTime <= 0) {
                     if(!stack.isEmpty()) {
                        currentStart = stack.pop();
                        currentSub = map.get(currentStart);
                        restTime = Integer.parseInt(currentSub[1]);
                    }
                }
            
            if(map.get(currentTime) !=  null) {
                //끝난 녀석 안 불러오게
                //rest값이 0보다 갖거나 작으면 skip
                if(!nextDay){
                    //현재 restTime 값이 0보다 크면 stack에 추가
                    if(restTime > 0) stack.push(currentStart);
                    //현재 값을 불러옴
                    currentStart = currentTime;
                    currentSub = map.get(currentStart);
                }
            }
        }
        
        return answer;
    }
    
    public boolean FirstTime(String S) {
        StringTokenizer st = new StringTokenizer(currentTime, ":");
        int c_h = Integer.parseInt(st.nextToken());
        int c_m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(S, ":");
        int S_h = Integer.parseInt(st.nextToken());
        int S_m = Integer.parseInt(st.nextToken());
        if(c_h < S_h) return false;
        if(c_h > S_h) return true;
        if(c_m > S_m) return true;
        return false;
    }
    
    public String getTime(int playtime) {
        StringTokenizer st = new StringTokenizer(currentTime, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        m = m + playtime;
        while(m >= 60) {
            h += 1;
            m = m - 60;
        }
        if(h >= 24) {
            h = h - 24;
            nextDay = true;
        }
        
        String H = h +"";
        
        if(h < 10) {
            H = "0" + h;
        }
        
        String M = m +"";
        
        if(m < 10) {
            M = "0" + m;
        }
        return H + ":" + M;
    }
}