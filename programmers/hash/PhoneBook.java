package programmers.hash;

import java.util.Arrays;

public class PhoneBook {
    class Solution {
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);

            // 앞 번호가 뒷 번호의 접두어인지 확인
            for (int i = 0; i < phone_book.length - 1; i++) {
                if(phone_book[i + 1].startsWith(phone_book[i])) {
                    return false;
                }
            }

            return true;
        }
    }
}
