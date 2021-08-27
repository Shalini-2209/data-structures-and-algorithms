package slidingwindow;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String str = "timetopractice";
        String t = "toc";
        int ans = findMinWindow(str, t);
        System.out.println("Minimum window: " + ans);
    }

    private static int findMinWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0, min=Integer.MAX_VALUE;
        String res = "-1";

        for (int k = 0; k < t.length(); k++) {
            char ch = t.charAt(k);
            if(map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
        }

        int count = map.size();

        while(j<s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch) ){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) count--;
            }
            if(count > 0) j++;

            else if(count == 0) {
                while(count == 0){
                    min = Math.min(min, j - i + 1);
                    if(res == "-1" || min < res.length())
                        res= s.substring(i, j+1);

                    if(map.containsKey(s.charAt(i)))
                    {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                        if(map.get(s.charAt(i)) > 0) count += 1;
                    }
                    else map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        System.out.println(res);
        return min;

    }
}
