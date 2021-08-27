package recursion;

import java.util.ArrayList;

public class GenerateBalancedParentheses {
    // Extended ip-op are of different types
    public static void main(String[] args) {
        ArrayList<StringBuilder> list = new ArrayList<>();
        int n = 2;

        solve(n, n, list, new StringBuilder(""));
        System.out.println(list);
    }

    private static void solve(int open, int close, ArrayList<StringBuilder> list, StringBuilder op) {

        if(open == 0 && close == 0){
            list.add(op);
            return;
        }

        if(open != 0){
            StringBuilder op1 = new StringBuilder(op);
            op1.append("(");
            solve(open-1,close,list,op1);
        }

        if(close > open){
            StringBuilder op2 = new StringBuilder(op);
            op2.append(")");
            solve(open,close-1,list,op2);
        }
    }
}
