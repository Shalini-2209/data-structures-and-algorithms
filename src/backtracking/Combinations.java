package backtracking;

public class Combinations {
    static int count = 0;
    public static void main(String[] args) {
        selectBoxes(1, 4, 0, 2, "");
        System.out.println(count);
    }
    // current box, total box, selected boxes, total selections => ncr = n => total boxes
    private static void selectBoxes(int cb, int tb, int sb, int ts, String s) {
        if(cb > tb){
            if(sb == ts){
                count++;
                System.out.println(s);
            }
            return;
        }

        // Not including current box
        selectBoxes(cb+1, tb, sb, ts, s + "_");
        // Including current box
        selectBoxes(cb+1, tb, sb + 1, ts, s + "x");
    }
}
