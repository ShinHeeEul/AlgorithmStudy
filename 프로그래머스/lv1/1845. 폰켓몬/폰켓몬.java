import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) sum++;
            map.put(nums[i],i);
        }
        if((map.size() + sum)/2 > map.size()) return map.size(); 
        return (map.size() + sum)/2;
    }
}