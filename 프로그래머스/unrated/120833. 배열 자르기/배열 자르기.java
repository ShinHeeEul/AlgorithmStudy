import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] numbers, int num1, int num2) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = num1; i <= num2 ; i++) {
            arr.add(numbers[i]);
        }
        return arr;
    }
}