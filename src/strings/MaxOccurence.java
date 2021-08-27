package strings;

import java.lang.*;
import java.io.*;
import java.util.*;

public class MaxOccurence {

    public static void main(String[] args) {
        System.out.println(getMaxOccuringChar("output"));
    }


        public static char getMaxOccuringChar(String line)
        {
            int max_val = Integer.MIN_VALUE;
            int great = 0;
            char arr[] = line.toCharArray();
            Map<Character, Integer> map = new HashMap<>();

            for(char ch : arr){
                if(!map.containsKey(ch))
                    map.put(ch, 1);
                else{
                    map.put(ch , map.get(ch) + 1);
                }
            }

            System.out.println(map);

            for(char ch: map.keySet()){
                if(max_val != map.get(ch)){
                    max_val = Math.max(max_val, map.get(ch));
                    if(max_val == map.get(ch))
                        great = (int)ch;
                }
                else{
                    System.out.println(great);
                    great = ((int)ch < great) ? ch : great;
                }

            }
            String ch = "22";
            System.out.println();

            return (char)great;
        }


}
