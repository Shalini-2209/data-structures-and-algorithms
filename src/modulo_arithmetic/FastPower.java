package modulo_arithmetic;

import java.math.BigInteger;
import java.util.ArrayList;

public class FastPower {
    public static void main(String[] args) {
        System.out.println(findPower(73333333, 2222222, 100000007));
//        findFact(5);
    }

    private static void findFact(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        BigInteger bi = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Max val: " + bi.divide(BigInteger.TEN));
        String val = bi.toString();

        for (int i = 0; i < val.length(); i++) {
            list.add(Character.getNumericValue(val.charAt(i)));
        }
        System.out.println(list);
    }

    private static long findPower(long a, long b, int n) {
        long res = 1;

        while(b > 0){

            if((b&1)!= 0){
               res = res % n * a % n;
            }

            a = a % n * a % n;
            b = b >> 1;
        }

        return res;
    }
}
