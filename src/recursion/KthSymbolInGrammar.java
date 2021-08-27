package recursion;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        System.out.println(findKthSymbol(4, 3));
    }

    private static int findKthSymbol(int n, int k) {
        if(n == 1 && k == 1) return 0;

//        Finds the mid since all the numbers till mid are same;
        int mid = (int)Math.pow(2, n-1) / 2;
//        System.out.println( (1 << n-1)) /2);

        if(k <= mid) return findKthSymbol(n-1, k);
        else {
           return findKthSymbol(n - 1, k - mid) == 0 ? 1 : 0;
        }
    }
}

//Given n=4
//        1. 0
//        2. 01
//        3. 0110
//k = 3   4. 01 |1| 01001