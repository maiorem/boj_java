import java.util.*;

class Solution {
    public void DFS(int n, int from, int to, List<int[]> answerList) {
        if(n == 1) {
            answerList.add(new int[]{from, to});
            return;
        }
        int empty = 6 - from - to;
        
        DFS(n-1, from, empty, answerList);
        DFS(1, from, to, answerList);
        DFS(n-1, empty, to, answerList);

    }


    public int[][] solution(int n) {
        int[][] answer = {};
        List<int []> answerList = new ArrayList<>();
        DFS(n, 1, 3, answerList);
        answer = new int[answerList.size()][];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}