import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (map.containsKey(num)) map.compute(num, (k, v) -> v.intValue() + 1);
            else map.put(num, 1);
        }
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            sb.append(map.getOrDefault(sc.nextInt(), 0)).append(" ");
        }
        System.out.println(sb);
    }
}