package strings;

public class Permutations {
    public static void main(String[] args) {
        findPer("abc");
}

    private static void findPer(String str) {
         int f = findFact(str);
         int n = str.length();

        for (int i = 0; i < f; i++) {
            int temp = i;
            StringBuilder sb = new StringBuilder(str);
            System.out.println("My new str is" + sb.toString());
            for (int j = n; j >= 1 ; j--) {
                int q = temp/j;
                int r = temp%j;

                System.out.println(sb.charAt(r));
                sb.deleteCharAt(r);

                temp = q;
            }
            System.out.println();
        }

    }

    private static int findFact(String str) {

        int fact = 1;

        for (int i = 2; i <= str.length() ; i++) {
            fact *= i;
        }

        System.out.println(fact);

        return fact;
    }
}
