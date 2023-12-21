class Solution {
    public int solution(int[] numbers, int k) {
        int people = numbers.length;
        return (k * 2 - 1)  % people == 0?people:(k*2 - 1) % people;
    }
}