import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = bfs(maps);

        return answer == 1 ? -1 : answer;
    }
    private int bfs(int[][] maps){

        int rowSize = maps.length;
        int colSize = maps[0].length;

        Deque<int[]> que = new ArrayDeque<>();

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        que.offer(new int[]{0,0,1});

        while(!que.isEmpty() && maps[rowSize-1][colSize-1] == 1){
            int[] tmp = que.poll();
            for(int i=0;i<4;i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                int val = tmp[2];
                if(nx < 0 || ny < 0
                        || nx >= rowSize || ny >= colSize
                        || maps[nx][ny] != 1) continue;

                que.offer(new int[]{nx,ny,val+1});
                maps[nx][ny] = val+1;
            }
        }

        return maps[rowSize-1][colSize-1];
    }
}