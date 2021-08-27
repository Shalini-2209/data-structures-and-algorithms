package strings;

//String compression using two pointer approach

class Solution {
    public static int compress(char[] chars) {
        int index = 0;
        int i = 0;

        while(i < chars.length){
            int j = i;

            while(j < chars.length && chars[i] == chars[j]){
                j++;
            }

            chars[index++] = chars[i];

            if(j-i > 1){
                String count = j - i + "";

                for(char c: count.toCharArray()){
                    chars[index++] = c;
                }

            }
            i = j;
        }
        return index;
    }
}
public class Compression2 {
    public static void main(String[] args) {
        String[] chars = {"a","b","b","b","b","b","b","b","b","b","b","b","b"};
        char[] a = {'a', 'a', 'a', 'b','b'};
        int ans = Solution.compress(a);
        System.out.println(ans);
    }

}
