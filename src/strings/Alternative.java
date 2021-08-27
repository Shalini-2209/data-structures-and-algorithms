package strings;

public class Alternative {
    public static int alternatingCharacters(String s) {
        int delete = 0;

        for(int i=0; i<s.length(); i++){
            if(i+1<s.length() && s.charAt(i) == s.charAt(i+1) ){
                delete++;
            }
        }
        return delete;
    }

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAABB"));
    }
}
