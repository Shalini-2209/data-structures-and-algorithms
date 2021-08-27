package slidingwindow;

import java.util.HashMap;
import java.util.Map;

// Longest sub string with k unique char
public class LongestSAUniqueChar {
    public static void main(String[] args) {
        int k = 3;
        String str = "aabacbebebe";
        int ans = findLongLength(k, str);
        System.out.println(ans);
    }

    private static int findLongLength(int k, String s) {
        int i=0, j=0, max = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(j < s.length()){
            if(!map.containsKey(s.charAt(j))) map.put(s.charAt(j) , 1);
            else map.put(s.charAt(j), map.get(s.charAt(j)) + 1);

            if(map.size() < k) j++;

            else if(map.size() == k){
                int count = 0;
                for(int m : map.values()){
                    count += m;
                }
                max = Math.max(max, count);
                j++;
            }

            else if(map.size() > k){
                while(map.size() > k){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i)) ;
                i++;
                }

                j++;
            }
        }
        return max;
    }
}
