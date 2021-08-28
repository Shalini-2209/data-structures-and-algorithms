package dp.group1;

public class StockBuySell {
    public static void main(String[] args) {
        int saving = 250;
        int buy[] = {175, 133, 109, 210, 97};
        int sell[] ={200, 125, 128, 228, 133};

        System.out.println(findMaxProfit(buy, sell, buy.length, saving));
    }

    private static int findMaxProfit(int[] buy, int[] sell, int n, int saving) {
        if(n == 0 || saving == 0) return 0;

        if(buy[n-1] <= saving){
            return Math.max((sell[n-1] - buy[n-1]) + findMaxProfit(buy, sell, n-1, saving - buy[n-1]),
                    findMaxProfit(buy, sell, n-1, saving));
        }

        else return findMaxProfit(buy, sell, n-1, saving);
    }
}
