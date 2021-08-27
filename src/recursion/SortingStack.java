package recursion;

import java.util.Stack;

public class SortingStack {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(3);
        stk.push(6);
        stk.push(2);

        sort(stk);

        System.out.println("SORTED STACK ");
        for (int i = stk.size() - 1; i >= 0 ; i--) {
            System.out.print(stk.get(i) + " ");
        }
    }

    private static void sort(Stack<Integer> stk) {
        int n= stk.size();

        if(n == 1) return;
        int last = stk.pop();
        sort(stk);
        insertLast(last, stk);
    }

    private static void insertLast(int elt, Stack<Integer> stk) {

        if(stk.size() == 0 || stk.peek() > elt) {
            stk.push(elt);
            return;
        }
        int last = stk.pop();
        insertLast(elt, stk);
        stk.push(last);
    }
}
