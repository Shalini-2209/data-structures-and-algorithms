package recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        // IBH - Induction Base Hypothesis method
        Stack<Integer> stk = new Stack<>();
        stk.push(3);
        stk.push(6);
        stk.push(2);
        System.out.println("Before reversing: ");
        System.out.println(stk);
        reverse(stk);
        System.out.println("After reversing: ");
        System.out.println(stk);
    }

    private static void reverse(Stack<Integer> stk) {
        if(stk.size() == 1) return;

        int last = stk.pop();
        reverse(stk);
        insert(last, stk);
    }

    private static void insert(int elt, Stack<Integer> stk) {
        if(stk.size() == 0){
            stk.push(elt);
            return;
        }
        int last = stk.pop();
        insert(elt, stk);
        stk.push(last);
    }
}
