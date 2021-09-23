package recursion;

public class PermutationOfGivenString {
    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str, "");
    }

    private static void findPermutations(String str, String res) {
        if(str.length() == 0) {
            System.out.println(res);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // abc => if b is chosen, a becomes left, c becomes right
            String left = str.substring(0, i);
            String right = str.substring(i+1);
            findPermutations(left+right, res + ch);
        }
    }
}
