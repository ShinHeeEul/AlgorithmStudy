class Solution {
    public String[] solution(String[] strings, int n) {
        for(int i = 0; i < strings.length; i++) {
            for(int j = i; j < strings.length; j++) {
                char aa = strings[i].charAt(n);
                char bb = strings[j].charAt(n);
                
                if(aa > bb) {
                    String tmp = strings[j];
                    strings[j] = strings[i];
                    strings[i] = tmp;
                } else if(aa == bb) {
                    if(strings[j].compareTo(strings[i]) < 0) {
                        String tmp = strings[j];
                        strings[j] = strings[i];
                        strings[i] = tmp;
                    }
                }
            }
        }
        return strings;
    }
}