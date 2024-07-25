class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder temp = new StringBuilder();
        String[] strArray = s.split(" ");
        for(String str: strArray) {
            for(int i = 0; i < str.length(); i++) {
                if (i == 0 && !Character.isDigit(str.charAt(i))) {
                    temp.append(Character.toUpperCase(str.charAt(i)));
                }else if ( str.length() == 0 ){
                    temp.append(" ");
                }else {
                    temp.append(Character.toLowerCase(str.charAt(i)));
                }
            }
            temp.append(" ");
        }
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return temp.toString();
        }
        temp.deleteCharAt(temp.length() - 1);
        answer = temp.toString();
        return answer;
    }

}