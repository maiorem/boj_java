class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];	
        int[] alphabet = new int[26];
        for(int i = 0; i < 26; i++){
            alphabet[i] = Integer.MAX_VALUE;	
        }
        for(String key : keymap){
            char[] arr = key.toCharArray();	
            for(int i = 0; i < arr.length; i++){	
                alphabet[arr[i] - 'A'] = Math.min(i, alphabet[arr[i] - 'A']);
            }
        }
        int j=0;
        for(String target : targets){
            int count = 0;	
            char[] arr = target.toCharArray();
            for(int i = 0; i < arr.length; i++){
                if(alphabet[arr[i] - 'A'] == Integer.MAX_VALUE){	
                    count = -1;
                    break;
                }
                count += alphabet[arr[i] - 'A'] + 1;	
            }
            answer[j++] = count;
        }

        return answer;
    }
}