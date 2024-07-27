import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();
        // 의상 종류(key)에 따른 의상 수(value)
        for (String[] cloth : clothes) {
            clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0) + 1);
        }
        // 각 종류에 따른 의상수에 +1(선택하지 않은 경우의 수 포함)을 하고 곱한다.
        for (String type : clothesMap.keySet()) {
            answer = answer * (clothesMap.get(type) + 1);
        }
        // 아무것도 선택하지 않은 케이스 빼기
        return answer - 1;
    }
}