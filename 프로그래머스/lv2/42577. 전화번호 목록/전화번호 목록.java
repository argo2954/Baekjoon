import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        int len = phone_book.length;
        for(int i=0; i<len-1; i++){
            if(phone_book[i+1].indexOf(phone_book[i])==0)
                return false;
        }
        
        return true;
    }
}