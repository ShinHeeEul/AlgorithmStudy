class Solution {
    public int solution(int[] arr) {
        
        int[] tmp = arr.clone();
        boolean b = false;
        
        for(int x = 0; ;x++) {    
            b = false;
            for(int i = 0; i < tmp.length; i++) {
                if((tmp[i] % 2 == 0) && (tmp[i] >= 50)) {
                    tmp[i] /= 2;
                    if(tmp[i] != arr[x]) b = true;
                }
                else if((tmp[i] % 2 != 0) && (tmp[i] < 50)) {
                    tmp[i] *= 2;
                    tmp[i] += 1;
                    if(tmp[i] != arr[x]) b = true;
                }
                
            }
            if(!b) {
                return x;
            }
                arr = tmp.clone();
        }
    }
}