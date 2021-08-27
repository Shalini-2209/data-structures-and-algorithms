package recursion;

public class Print {
    // IBH - Induction Base Hypothesis method

    public static void main(String[] args) {
        printNValues(5);
    }

    private static void printNValues(int n) {
        // Base condition
        if(n == 1) {
            System.out.println("1");
             return;
        }
        // Hypothesis
        printNValues(n-1);

        // Induction
        System.out.println(n);
    }
}
