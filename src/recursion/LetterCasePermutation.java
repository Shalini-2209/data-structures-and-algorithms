package recursion;

public class LetterCasePermutation {
    public static void main(String[] args) {
        solve(new StringBuilder("a1B2"), new StringBuilder(""));
    }

    private static void solve(StringBuilder ip, StringBuilder op) {
        if(ip.length() == 0){
            System.out.println(op);
            return;
        }

        StringBuilder newIp = new StringBuilder(ip);
        StringBuilder op1 = new StringBuilder(op);
        newIp.deleteCharAt(0);

        if(Character.isLetter(ip.charAt(0))) {
            StringBuilder op2 = new StringBuilder(op);
            op1.append(Character.toUpperCase(ip.charAt(0)));
            op2.append(Character.toLowerCase(ip.charAt(0)));
            solve(newIp, op1);
            solve(newIp, op2);
        }
        else{
            op1.append(ip.charAt(0));
            solve(newIp, op1);
        }

    }
}
