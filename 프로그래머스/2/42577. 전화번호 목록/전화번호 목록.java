import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
		for(int i = 1; i<phone_book.length; i++) {
			String prefix = phone_book[i-1];
			if(phone_book[i].startsWith(prefix)) {
				return false;
			}
		}
		
		return true;
    }
}