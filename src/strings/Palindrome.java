package strings;

public class Palindrome {
    public static void main(String[] args) {
        String str = "wow";
        getsubStrings(str);

    }

    private static void getsubStrings(String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                temp = Character.toString(str.charAt(i)) + Character.toString(str.charAt(j));
                if(isPalindrome(temp))
                    System.out.println(temp + " is a valid palindrome" );
                else
                    System.out.println(temp + "INVALID");
            }
        }
    }

    private static boolean isPalindrome(String str) {
        boolean valid = true;
        for (int i = 0; i < str.length(); i++) {
            int next = str.length() - (i + 1);
            if(str.charAt(i) != str.charAt(next)) {
                valid = false;
                break;
            }
            else
                continue;
        }
        return valid;
    }
}
