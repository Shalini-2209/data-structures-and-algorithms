package slidingwindow;

import java.util.*;

public class AnagramCount {
    public static void main(String[] args) {
        int res = countAnagrams("forxxorfxdofr", "for");
        System.out.println(res);
    }

    private static int countAnagrams(String text, String ptn) {

        int i=0, j=0 ;
        int ans = 0, k=ptn.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int m = 0; m < ptn.length(); m++) {
            if (!map.containsKey(ptn.charAt(m)))
                map.put(ptn.charAt(m), 1);
            else map.put(ptn.charAt(m), map.get(ptn.charAt(m)) + 1);
        }

        int count = map.size();

        while(j < text.length()){
            if(map.containsKey(text.charAt(j))) {
                map.put(text.charAt(j), map.get(text.charAt(j)) - 1);
                if(map.get(text.charAt(j)) == 0)
                count--;
            }
            System.out.println(map);
            if(j-i+1 < k) j++;

            else if(j-i+1 == k){
                if(count == 0) ans++;

                if(map.containsKey(text.charAt(i))) {
                    map.put(text.charAt(i), map.get(text.charAt(i)) + 1);
                    if(map.get(text.charAt(i)) == 1) count++;
                }

                i++ ; j++;
            }
        }
        return ans;
    }
}