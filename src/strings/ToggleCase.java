package strings;

public class ToggleCase {
    public static void main(String[] args) {
        String str = "AeRoPlAnE";
        System.out.println(toggle(str.toCharArray()));
    }

    private static String toggle(char arr[]){
        for (int i = 0; i < arr.length; i++) {
            arr[i] ^= 32;
        }

        return new String(arr);
    }
}
