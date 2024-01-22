import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] numbers, String direction) {
        ArrayList<Integer> list = new ArrayList<>();
        if(direction.equals("right")) {
                for(int num : Arrays.copyOfRange(numbers, 0, numbers.length - 1)) {
                    list.add(num);
                }
                list.add(0, numbers[numbers.length - 1]);
        } else {
            for(int num : Arrays.copyOfRange(numbers, 1, numbers.length)) {
                list.add(num);
            }
                list.add(numbers[0]);
        }
        return list;
    }
}