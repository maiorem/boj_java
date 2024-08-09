import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int count = 0; // 최종 보트 개수
        int startIdx = 0; // 무게가 가장 작은 사람부터 탐색할 인덱스
        int endIdx = people.length - 1; // 무게가 가장 무거운 사람부터 탐색할 인덱스
        Arrays.sort(people); // 오름차순 정렬

		// startIdx가 endIdx보다 커야 모든 사람 탐색 완료
        while (startIdx <= endIdx) {

            // 두 사람 무게의 합이 limit 이하면 함께 탑승 가능
            // 두 사람이 탑승했으므로, startIdx, endIdx 모두 증가/보트 수 증가
            if (people[startIdx] + people[endIdx] <= limit) {
                startIdx++;
                endIdx--;
                count++;
            }
            
            // 두 사람 무게의 합이 limit 이상이면
            // endIdx에 있던 사람은 무조건 혼자 탑승 해야히므로, endIdx감소/보트 수 증가
            else {
                endIdx--; 
                count++;
            }
        }


        return count;
    }
}