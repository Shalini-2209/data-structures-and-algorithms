package dp.group5;

import java.util.Arrays;

public class BuildingBridges {
    static class Coordinates implements Comparable<Coordinates>{
        // (north, south) coordinates
        int n;
        int s;

        Coordinates(int nr, int so){
            n = nr;
            s = so;
        }

        public int compareTo(Coordinates o){
            if(this.n != o.n)
                return this.n - o.n;
            else return this.s - o.s;
        }

    }
    public static void main(String[] args) {
        int north[] = {6, 4, 2, 1};
        int south[] = {2, 3, 6, 5};

        System.out.println(findMaxNonOverlappingBridges(north, south, north.length));
    }

    private static int findMaxNonOverlappingBridges(int[] north, int[] south, int n) {
        Coordinates bridge[] = new Coordinates[n];

        for (int i = 0; i < n; i++)
            bridge[i] = new Coordinates(north[i], south[i]);

        Arrays.sort(bridge);

        int dp[] = new int[n];

        int omax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(bridge[j].s <= bridge[i].s){
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            omax = Math.max(dp[i], omax);
        }

        return omax;
    }
}
