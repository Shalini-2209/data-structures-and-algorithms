package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PickToys {
    public static void main(String[] args) {
        int k = 2;
        String s = "aabacea";
        findMaxToys(s, k);
    }

    private static void findMaxToys(String s, int k) {

        int i=0, j=0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(j < s.length()){
            char ch = s.charAt(j);
            if(!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch) + 1);

            if(map.size() < k) j++;

            else if(map.size() == k){
                int count = 0;
                for (int val:
                     map.values()) {
                    count += val;
                }
                max = Math.max(count, max);
                j++;
            }

            else if(map.size() > k){
                while(map.size() > k){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }

        System.out.println(max);
    }
}
