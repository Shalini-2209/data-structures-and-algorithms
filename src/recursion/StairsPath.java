package recursion;

public class StairsPath {
    public static void main(String[] args) {
        findPaths(3, 3, "");
        int count = countPaths(3, 3 );
        System.out.println("No of paths by jumping 3 steps " + count);
    }

    private static int countPaths(int stairs, int jumps) {

        if(stairs <= 1) return 1;
        int paths = 0;

        for (int i = 1; i < stairs && i <= jumps; i++) {
            paths = countPaths(stairs-i , jumps);
        }
        return paths;
    }

    private static void findPaths(int n, int jumps, String path) {
        if(n == 0){
            System.out.println(path);
            return;
        }
        else if(n < 0){
            System.out.println("xxx");
            return;
        }

        for (int i = 1; i <= jumps; i++) {
            findPaths(n - i, jumps, path+i);
        }
    }
}
