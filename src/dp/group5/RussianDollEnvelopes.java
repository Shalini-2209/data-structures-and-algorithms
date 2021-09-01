package dp.group5;

import java.util.Arrays;

public class RussianDollEnvelopes{
    static class Envelope implements Comparable<Envelope>{
        int height;
        int width;

        Envelope(int h, int w){
            height = h;
            width = w;
        }

        public int compareTo(Envelope e){
            return this.width - e.width;
        }
    }

    public static void main(String[] args) {
        int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        System.out.println(maxEnvelopes(envelopes));
    }

    private static int maxEnvelopes(int[][] envelopes) {
        Envelope env[] = new Envelope[envelopes.length];

        for (int i = 0; i < envelopes.length; i++) {
            env[i] = new Envelope(envelopes[i][1], envelopes[i][0]);
        }

        Arrays.sort(env);

        return lis(env, env.length);
    }

    private static int lis(Envelope[] env, int n) {
        int omax = 0;
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(env[i].height > env[j].height && env[i].width > env[j].width)
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            omax = Math.max(dp[i], omax);
        }

        return omax;
    }
}
