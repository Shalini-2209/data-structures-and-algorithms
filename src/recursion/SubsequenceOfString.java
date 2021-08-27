package recursion;

public class SubsequenceOfString {
    public static void main(String[] args) {
        System.out.println("The subsets are: ");
        String s = "abc";
        getSubsets(s, "", 0, s.length());
    }

    private static void getSubsets(String ip, String op, int index, int n) {
        if(index == n){
            System.out.println(op);
            return;
        }

        getSubsets(ip, op + ip.charAt(index), index+1, n);
        getSubsets(ip, op, index+1, n);
    }
}