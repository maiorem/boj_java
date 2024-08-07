import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[][] relations;
    static boolean[] check; //체크 여부 저장
    static int n;

    public static int dfs(int first, int second, int num) {
        if (first == second) {
            return num; //같으면 촌수 반환
        }

        check[first] = true;

        int r = -1;
        for (int i = 1; i <= n; i++) {
            if (relations[first][i] == 1 && check[i] == false) {
                int next = dfs(i, second, num + 1);
                if (next != -1 && next >= r) {
                    r = next;
                }
            }
        }

        return r;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        int p1 = in.nextInt();
        int p2 = in.nextInt();

        int m = in.nextInt();

        relations = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            relations[x][y] = 1;
            relations[y][x] = 1;
        }
        System.out.print(dfs(p1, p2, 0));
    }
}
