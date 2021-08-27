package strings;

public class ValidIP {
    public static void main(String[] args) {
        System.out.println(isValid(" "));
    }
    public static boolean isValid(String s) {
        s = s.replaceAll(" ", "");
        if(s.length() == 0)
            return false;

        String[] tokens = s.split("\\.");

        if(tokens.length == 4){
            for(String ch: tokens){
                int i=Integer.parseInt(ch);
                if(i < 0 || i > 255)
                    return false;
            }
            return true;
        }
        return false;
    }
}
