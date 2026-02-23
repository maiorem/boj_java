import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int idx = 0;
        while (idx < N) {
            if (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                st = new StringTokenizer(line);
                continue;
            }
            A[idx++] = Integer.parseInt(st.nextToken());
        }
        br.close();
        System.out.println(solution(N, A));
    }

    public static int solution(int N, int[] A) {
        if (N == 0) {
            return 0;
        }
        int[] numbers = new int[N];
        int result = 1;
        for (int i = 0; i < N; i++) {
            numbers[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] > A[i]) {
                    numbers[i] = Math.max(numbers[i], numbers[j] + 1);
                }
            }
            result = Math.max(result, numbers[i]);
        }
        return result;
    }

}
