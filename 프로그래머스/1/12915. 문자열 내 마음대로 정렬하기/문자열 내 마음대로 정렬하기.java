import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Map<String, Character> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, str.charAt(n));
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        keySet.sort(Comparator.comparing(map::get));
        answer = keySet.toArray(new String[0]);

        return answer;
    }
}