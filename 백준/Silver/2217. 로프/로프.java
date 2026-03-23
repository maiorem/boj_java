import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = nextInt();
        }
        System.out.println(solution(arr));

    }

    private static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException("Not enough input.");
            }
            st = new StringTokenizer(line.replace("\uFEFF", ""));
        }
        return Integer.parseInt(st.nextToken());
    }

    public static int solution(int[] arr) {
        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int weight = arr[i] * (arr.length - i);
            result = Math.max(result, weight);
        }
        return result;
    }

}
