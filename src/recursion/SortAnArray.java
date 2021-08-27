package recursion;

import java.util.ArrayList;

public class SortAnArray {

    public static void main(String[] args) {
        // IBH - Induction Base Hypothesis method
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(3);
        list.add(0);

        sort(list);
        System.out.println(list);
    }

    private static void sort(ArrayList<Integer> list) {
        int n = list.size();

        if(n == 1) return;
        int last = list.remove(n-1);

        sort(list);

        insert(list, last);
    }



    private static void insert( ArrayList<Integer> list, int elt) {
        int n = list.size();

        if(n == 0 || elt >= list.get(n-1)) {
            list.add(elt);
            return;
        }

        int last = list.remove(n-1);

        insert(list, elt);
        list.add(last);
    }
}
