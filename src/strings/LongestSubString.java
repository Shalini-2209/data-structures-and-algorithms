package strings;

import java.util.HashMap;
import java.util.Map;

//Longest substring with no repeated chars
public class LongestSubString {
    public static void main(String[] args) {
        char c = 97;
        System.out.println(c);
        System.out.println("Length of longest substring: " + getLString("geeksforgeeks"));
    }

    private static int getLString(String s) {

        int i = -1, j = -1;
        int ans = 0;
        Map <Character, Integer> map = new HashMap<>();
        while(true){
            boolean f1 = false, f2 = false;

            while(i < s.length() - 1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if(map.get(ch) == 2)
                    break;
                else{
                    int len = i - j;
                    ans = Math.max(ans, len);
                }
            }

            //release
            while(j < i){
                f2 = true;
                j++;
                char ch = s.charAt(j);

                map.put(ch, map.get(ch) - 1);

                if(map.get(ch) == 1)
                    break;
            }

            if(f1 == false && f2 == false) break;
        }
        return ans;
    }
}
