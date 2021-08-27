package strings;

public class ReverseWords {
    public static void main(String[] args) {
        String res = reverseWords("..this.is.me..");

        System.out.println(res);

    }
    static String reverseWords(String s)
    {
        StringBuilder str = new StringBuilder("");

        int i = s.length()-1;
        System.out.println(s.length());

        while (i >= 0){

            while(i >= 0 && s.charAt(i) == '.') i--;

            int j = i;

            if(i < 0) break;

            while(i >= 0 && s.charAt(i) != '.' ){
                i--;
            }


            if(str.toString().isEmpty())
                str.append(s.substring(i+1 , j+1));
            else {
                str.append('.');
                str.append(s.substring(i + 1, j + 1));
            }
        }

        return str.toString();
    }
}
