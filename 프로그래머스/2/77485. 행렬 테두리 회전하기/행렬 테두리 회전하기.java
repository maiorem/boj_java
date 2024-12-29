import java.util.*;

class Solution {
    
    static int [] answer;
    static int [][] map;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static Queue<Integer> queue = new LinkedList<>();

    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        int cnt = 1;
        map = new int[rows][columns];
        
        // 행렬 생성
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                map[i][j] = cnt++;
            }
        }

        for(int i = 0; i < queries.length; i++){
            rotateAndFindMin(queries[i], i);
        }
        return answer;
    }
    
    //한 행을 회전한 후 가장 작은 수 찾기 메서드
    public static void rotateAndFindMin(int [] query, int index){
        int x = query[0] - 1;
        int y = query[1] - 1;
        int sx = x;
        int sy = y;
        int ex = query[2];
        int ey = query[3];
        int min = map[x][y];

        queue.add(map[x][y]);

        for(int i = 0; i < 4; i++){
            while(true){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(sx <= nx && sy <= ny && nx < ex && ny < ey){
                    if(nx != sx || ny != sy){
                        queue.add(map[nx][ny]);
                        min = Math.min(min, map[nx][ny]);
                    }
                    x = nx; y = ny;
                }
                else break;
            }
        }
        x = sx; y = sy;
        for(int i = 0; i < 4; i++){
            while(!queue.isEmpty()){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(sx <= nx && sy <= ny && nx < ex && ny < ey){
                    map[nx][ny] = queue.poll();
                    x = nx; y = ny;
                }
                else break;
            }
        }
        answer[index] = min;
    }
}