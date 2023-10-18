import java.util.stream.Collectors;

class Solution {
    public int solution(String s) {
        String result = s.chars()
                        .mapToObj(c -> (char) c)
                        .collect(StringBuilder::new, (acc, current) -> {
                            if (acc.length() == 0 || acc.charAt(acc.length() - 1) != current) {
                                acc.append(current);
                            } else {
                                acc.setLength(acc.length() - 1);
                            }
                        }, StringBuilder::append)
                        .toString();
        
        return result.isEmpty() ? 1 : 0;
    }
}
