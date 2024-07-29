import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> features = new LinkedList<>();
        List<Integer> deployFeature = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            //각 progressces에 남은 작업 일수를 큐에 저장
            int remainDay = (100 - progresses[i]) / speeds[i];
            //나머지가 있으면 포함
            if ((100 - progresses[i]) % speeds[i] > 0) {
                remainDay++;
            } 
            features.offer(remainDay);
        }
        while (!features.isEmpty()) {
            //큐에 저장된 날짜가 뒷날짜보다 낮을때까지 pop
            int deployDay = features.poll();
            int count = 1;
            while (!features.isEmpty() && features.peek() <= deployDay) {
                features.poll();
                count++;
            }
            deployFeature.add(count);

        }
        answer = new int[deployFeature.size()];
        for (int i = 0; i < deployFeature.size(); i++) {
            answer[i] = deployFeature.get(i);
        }
        return answer;
    }
}