package strings;

public class Compression {
    public static void main(String[] args) {
        compress("aaabb");
//         isPrime(17);
    }

    private static void isPrime(int i) {
        for (int j = 2; j < Math.sqrt(i); j++) {
            if(i%j == 0) {
                System.out.println("not a prime");
                return;
            }
            else {
                System.out.println("is a prime");
                break;
            }
        }
    }

    private static void compress(String S) {

        if(S.length() == 1){
             String ans =  "1" + S.substring(0, 1);
            System.out.println(ans);
             return ;
        }

        StringBuilder s = new StringBuilder(S);

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) < 97){
                int val = (int)s.charAt(i) + 32;
                s.setCharAt(i, (char)val);
            }
        }

        String str = "";
        int count = 1;


        for(int i=1; i<s.length(); i++){

            char cur = s.charAt(i);
            char prev = s.charAt(i-1);

            if(prev == cur){
                count += 1;
            }

            else{
                    str += count;
                    count = 1;
                str += prev;
            }
            if(i == s.length() - 1) {
                str += count ;
                str += cur;
            }
        }

//            str += s.charAt(s.length() - 1);
//            count = 1;

        System.out.println(str + " " );
    }
}
