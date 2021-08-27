package recursion;

import java.util.Stack;

public class DeletingMiddleElementInStack {
    public static void main(String[] args) {
        // IBH - Induction Base Hypothesis method
        Stack<Integer> stk = new Stack<>();
        int mid = 0;

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        stk.push(6);

        if(stk.size() % 2 == 1) mid = (stk.size()/2) + 1;
        else mid = stk.size()/2;

        deleteMid(mid, stk);

        System.out.println(stk);
    }

    private static void deleteMid(int mid, Stack<Integer> stk) {

        if(stk.peek() == stk.get(mid - 1)) {
            stk.pop();
            return;
        }
        int last = stk.pop();

        deleteMid(mid, stk);

        stk.push(last);
    }

}
