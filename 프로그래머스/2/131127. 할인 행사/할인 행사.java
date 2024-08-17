import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int totalCount = 0;
        int nowCount = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();

        // 필요한 물건의 총 개수
        for (int num : number) {
            totalCount += num;
        }
        

        for (int i = 0; i <= discount.length - totalCount; i++) {
            // hashMap 입력
            for (int k = 0; k < want.length; k++) {
                wantMap.put(want[k], number[k]);
            }  
            nowCount = 10;


            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j]) == false || wantMap.get(discount[j]) <= 0) {
                    break;
                }
                else {
                    wantMap.put(discount[j], wantMap.get(discount[j]) - 1);
                    nowCount--;
                }
            }
            if (nowCount == 0) {
                answer++;
            }
        }

        return answer;
    }
}