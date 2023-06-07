class Solution {
    public int solution(String myString, String pat) {
     
        char[] mca = myString.toCharArray();
        char[] pca = pat.toCharArray();
        for(int i = 0; i < mca.length; i++) {
            if(mca[i] < 'a') {
                mca[i] -= 'A';
                mca[i] += 'a';
            }
        }
        
        for(int i = 0; i < pca.length; i++) {
            if(pca[i] < 'a') {
                pca[i] -= 'A';
                pca[i] += 'a';
            }
        }
        
        myString = new String(mca);
        pat = new String(pca);
        
        if(myString.contains(pat)) return 1;
        
        return 0;
    }
}