package dp.group3;

public class MinInsertionAndDeletion {
    //Minimum Number of Insertion and Deletion to convert String a to String b

    public static void main(String[] args) {
        String a = "heap";
        String b = "pea";

        int lcs = findUsingRec(a, b, a.length(), b.length());
        int minDeletion = a.length() - lcs;
        int minInsertion = b.length() - lcs;
        System.out.println("Minimum Number of Insertion and Deletion to convert String a to String b: ");
        System.out.println(minDeletion + minInsertion);

    }

    private static int findUsingRec(String a, String b, int n, int m) {
        if(n == 0 || m == 0) return 0;

        if(a.charAt(n-1) == b.charAt(m-1))
            return 1 + findUsingRec(a, b, n-1, m-1);
        else
            return Math.max(findUsingRec(a, b, n, m-1), findUsingRec(a, b, n-1, m));
    }
}
