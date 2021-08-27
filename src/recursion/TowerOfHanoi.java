package recursion;

public class TowerOfHanoi {
    private static int count = 0;

    public static void main(String[] args) {
        char src = 'A';
        char helper = 'B';
        char dest = 'C';
        int n = 4;

        moveDiscs(src, dest, helper, n);
        System.out.println("Number of moves: " + count);
    }

    private static void moveDiscs(char src, char dest, char helper, int n) {
        count++;
        // Moving the last plate left out in tower 1 to tower 3
        if(n == 1){
            System.out.println("Move plate " + n +" from " +  src + " to " + dest );
            return;
        }
        // Moving the n-1 plates left out in tower 1 to helper tower
        moveDiscs(src, helper, dest, n-1);
        System.out.println("Move plate " + n +" from " +  src + " to " + dest );
        // Moving the n-1 plates left out in helper tower to tower 3(dest)
        moveDiscs(helper, dest, src, n-1);
    }
}
