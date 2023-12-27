public class BuySellStock {
    public static int optimumSolution(int[] prices) {
        int lsf = Integer.MAX_VALUE; // least so far
        int op = 0; // overall profit
        int pist = 0; // profit if sold today

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) { // if we found new buy value which is more smaller then previous one
                lsf = prices[i]; // update our least so far
            }
            pist = prices[i] - lsf; // calculating profit if sold today by, Buy - sell
            if (op < pist) { // if pist is more then our previous overall profit
                op = pist; // update overall profit
            }
        }
        return op; // return op
    }

    public static int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, buy_idx = 0, sell;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
                buy_idx = i;
            }
        }

        sell = buy;
        for (int i = buy_idx + 1; i < prices.length; i++) {
            if (prices[i] > sell)
                sell = prices[i];
        }
        int profit_A = sell - buy;

        int selll = 0, sell_idx = 0, buyy;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > selll) {
                selll = prices[i];
                sell_idx = i;
            }
        }

        buyy = selll;
        for (int i = 0; i < sell_idx; i++) {
            if (prices[i] < buyy)
                buyy = prices[i];
        }
        int profit_B = selll - buyy;

        System.out.println("A:" + profit_A + " ,B:" + profit_B);
        return Math.max(profit_A, profit_B);
    }

    public static void main(String[] args) {
        int[] prices1={1,2,3};
        System.out.println("Max profit:" + optimumSolution(prices1));
        //System.out.println("Max profit:"+maxProfit(prices));

    }
}