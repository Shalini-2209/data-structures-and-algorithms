package recursion;

public class PermutationsWithSpaces {
    public static void main(String[] args) {
        StringBuilder ip = new StringBuilder("ABC");
        StringBuilder op = new StringBuilder("");
        op.append(ip.charAt(0));
        ip.deleteCharAt(0);
        solve(ip, op);
    }

    private static void solve(StringBuilder ip, StringBuilder op) {

        if(ip.length() == 0) {
            System.out.println(op);
            return;
        }

        StringBuilder op1 = new StringBuilder(op);
        StringBuilder op2 = new StringBuilder(op);

        op1.append("_" + ip.charAt(0));
        op2.append(ip.charAt(0));

        StringBuilder newIp = new StringBuilder(ip);
        newIp.deleteCharAt(0);

        solve(newIp, op1);
        solve(newIp, op2);
    }
}
