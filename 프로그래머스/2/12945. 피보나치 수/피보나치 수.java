class Solution {  
    
    public int solution(int n) {  
        int[] memory = new int[n+1];
        memory[1] = 1;
        memory[2] = 1;
        for(int i = 3; i <= n; i++) {
            memory[i] = (memory[i-1] + memory[i-2]) % 1234567;
        }
        return memory[n];
    }
}