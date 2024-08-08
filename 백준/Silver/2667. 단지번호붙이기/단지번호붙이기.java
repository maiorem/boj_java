import java.util.*;

class Map {
    int x;
    int y;
    public Map(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Main {

    static int n, count;
    static List<Integer> houses = new ArrayList<>();
    static int[][] graph;
    static boolean[][] checked;
    //4방향 좌표
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int dfs(int x, int y) {
        Queue<Map> queue = new LinkedList<>();
        queue.offer(new Map(x, y));
        checked[x][y] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            Map newMap = queue.poll();
            int cx = newMap.x;
            int cy = newMap.y;
            count++;

            // 4방향
            for (int i = 0; i < 4; i++) {

                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && graph[nx][ny] == 1 && !checked[nx][ny]){
                    checked[nx][ny] = true;
                    queue.offer(new Map(nx, ny));
                }
            }
        }
        return count;
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        graph = new int[n][n];
        checked = new boolean[n][n];

        for ( int i = 0 ; i < n ; i++ ) {
            String line = in.nextLine();
            for ( int j = 0 ; j < n ; j++ ) {
                graph[i][j] = line.charAt(j) - '0'; // 문자 '0' 또는 '1'을 정수로 변환
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !checked[i][j]) houses.add( dfs(i, j) );
            }
        }
        Collections.sort(houses);
        System.out.println(houses.size());
        for ( int i = 0 ; i < houses.size() ; i++ ) {
            System.out.println( houses.get( i ) );
        }
    }
}