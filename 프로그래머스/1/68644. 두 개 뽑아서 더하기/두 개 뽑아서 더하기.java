import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> sets = new HashSet<>();
        for(int i =0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++)
            sets.add(numbers[i] + numbers[j]);
        }
        
        for(int set : sets) {
            list.add(set);
        }
        Collections.sort(list);
        return list;
    }
}