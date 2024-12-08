class Solution {
    public int solution(String[][] book_time) {
        // 모든 시간 배열 미리 0으로 초기화
        int[] times = new int[25*60];
        for( String[] time : book_time ){
            int start =  toMinutes(time[0]);
            int end = toMinutes(time[1])+10;
            //예약이 잡혀있는 시간대를 배열에 1씩 카운트
            for(int i = start; i< end ; i++) times[i]++;
        }
        int max = 0;
        //회의가 잡힌 시간대들 중 가장 예약 카운트가 높은 시간 = 필요한 방 수
        for(int i : times) max = Math.max(max, i);
        return max;
    }

    private static int toMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

}