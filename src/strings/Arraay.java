package strings;

public class Arraay {
    public static void main(String[] args) {
        String s1 = "23";
        String s2 = "44";
        String ans = "1012";
        int arr[] = new int[s1.length() + s2.length()];
        int len = arr.length - 1;

        for (int i = ans.length() - 1; i >= 0; i--) {
           arr[len] = Character.getNumericValue(ans.charAt(i));
           len--;
        }
//        arr[len] = 5;

        for (int val : arr ) {
            System.out.println(val);
        }
    }
}
