package slidingwindow;
//Longest Substring With Without Repeating Characters

import java.util.HashMap;
import java.util.Map;

public class LongestSAWithNoRepition {
    public static void main(String[] args) {
        String s = "axdaaliqd";
        int ans = findMaxLength(s);
        System.out.println(ans);
    }

    private static int findMaxLength(String s) {
        int i=0, j=0, max=Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            if(!map.containsKey(s.charAt(j))) map.put(s.charAt(j) , 1);
            else map.put(s.charAt(j), map.get(s.charAt(j)) + 1);

             if (map.size() == j - i + 1){
//                System.out.println(map);
                max = Math.max(map.size(), max);
                j++;
            }

            else if(map.size() < j-i+1){
                while(map.size() < j-i+1 && map.containsKey(s.charAt(i))){
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
