package backtracking;

public class Permutations {

    public static void main(String[] args) {
        int arr[] = new int[4];
        permutate(arr, 1, 3);
    }

    private static void permutate(int[] arr, int ci, int ti) {
        // current item(ci), total items(ti)
        if(ci > ti) {
            for(int val : arr)
                System.out.print(val);

            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
           if(arr[i] == 0) // if the place is empty
            {
                arr[i] = ci;
                permutate(arr, ci + 1, ti);
                arr[i] = 0;
            }
        }
    }
}