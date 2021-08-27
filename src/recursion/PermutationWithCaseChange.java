package recursion;

// ab => aB, Ab, ab, AB

public class PermutationWithCaseChange {
    public static void main(String[] args) {
        solve(new StringBuilder("ab"), new StringBuilder(""));
    }

    private static void solve(StringBuilder ip, StringBuilder op) {
        if(ip.length() == 0){
            System.out.println(op + " ");
            return;
        }

        StringBuilder op1 = new StringBuilder(op);
        StringBuilder op2 = new StringBuilder(op);

        op1.append(ip.charAt(0));
        op2.append(Character.toUpperCase(ip.charAt(0)));

        StringBuilder newIp = new StringBuilder(ip);
        newIp.deleteCharAt(0);

        solve(newIp, op1);
        solve(newIp, op2);
    }
}
