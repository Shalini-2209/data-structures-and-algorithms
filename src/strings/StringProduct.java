package strings;

public class StringProduct {
    public static void main(String[] args) {
        String s1 = "1968";
        String s2 = "1592";

        if(s1 == "0" || s2 == "0" ) {
            System.out.println("0");
            return;
        }
        int arr[] = new int[s1.length() + s2.length()];
        boolean sign = true; //positive

        if(s1.contains("-") &&  s2.contains("-")){
            s1 = s1.replace("-", "");
            s2 = s2.replace("-", "");
        }
        else if(s1.contains("-")) {
            s1 = s1.replace("-", "");
            sign = false;
        }
        else if(s2.contains("-")) {
            s2 = s2.replace("-", "");
            sign = false;
        }

        char[] n1 = s1.toCharArray();
        char[] n2 = s2.toCharArray();

        int units = 0;

        StringBuilder res = new StringBuilder("");

        for (int i = n2.length - 1; i >= 0 ; i--) {
            int mul = Character.getNumericValue(n2[i]) ;
            int sum = 0;
            int carry = 0;
            for (int j = n1.length - 1; j >= 0; j--) {
                int temp = (Character.getNumericValue(n1[j]) * mul) + carry;
//                System.out.println(Character.getNumericValue(n1[j]) +  " * " +  mul + "  = "  + temp);
                if (temp > 9) {
                    sum = temp % 10;
                    carry = temp / 10;
                    res.insert(0, sum);
                    continue;
                }
                res.insert(0, temp);
                carry = 0;

            };

            if(carry !=0)
                res.insert(0, carry);

            int val = units;
            System.out.println(val);
            while(val > 0){
                res.append("0");
                val--;
            }
            units++;
            System.out.println( "Res:" + res);
            fillArr(res.toString(), arr);
            res.setLength(0);
        }

        for (int i: arr) {
            res.append(String.valueOf(i));
        }

        for(int i = 0; i < res.length(); i++){

            if(res.charAt(0) == '0') {
                res.deleteCharAt(0);
            }
            else
                break;
        }

        if(!sign)
            res.insert(0, '-');

        System.out.println("\nFinal ans " + res);
    }

    private static void fillArr(String str, int[] arr) {
        int len = arr.length-1;
        int carry = 0;
        
        for (int i = str.length() - 1; i >= 0; i--) {
            int n = Character.getNumericValue(str.charAt(i));

            if(len < arr.length && len >= 0) {
                int cur = arr[len];
                int temp = cur +  n + carry;

                if (temp > 9) {
                    carry = temp / 10;
                    arr[len] = temp % 10;
                    len--;
                    continue;
                }

                arr[len] = temp;
                len--;
                carry = 0;
            }
        }

        if(carry != 0)
            arr[len] = carry;

    }
}
