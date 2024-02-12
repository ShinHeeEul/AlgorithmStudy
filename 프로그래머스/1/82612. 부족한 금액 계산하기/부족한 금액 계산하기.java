class Solution {
    public long solution(int price, int money, int count) {
        long tmp = (long) price * (count * (count + 1) / 2);
        long answer = money - tmp;
        return answer < 0? -answer:0;
    }
}