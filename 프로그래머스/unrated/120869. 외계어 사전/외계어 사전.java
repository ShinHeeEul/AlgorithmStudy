class Solution {
    public int solution(String[] spell, String[] dic) {
        for(int i = 0; i < dic.length; i++) {
            String s = dic[i];
            boolean b = true;
            for(String sp : spell) {
                if(!s.contains(sp)) {
                    b = false;
                    break;
                }
            }
            if(b) {
                return 1;
            }
        }
        
        return 2;
    }
}