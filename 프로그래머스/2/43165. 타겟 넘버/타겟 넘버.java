class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    public int dfs(int[] numbers, int index, int currentSum, int target) {    
        if (index == numbers.length) {
            // 현재 합계가 목표 값과 일치하는지 확인
            return currentSum == target ? 1 : 0;
        }
        
        // 현재 인덱스의 숫자를 더하거나 빼는 두 가지 경우의 결과를 재귀적으로 계산하고 합산
        return dfs(numbers, index + 1, currentSum + numbers[index], target) 
             + dfs(numbers, index + 1, currentSum - numbers[index], target);
    }
}