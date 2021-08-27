package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class Knapsack {
    // Fractional Knapsack
    static class Thing implements Comparable<Thing>{
        int weight;
        int profit;
        double cost;

        Thing(int w, int p){
            weight = w;
            profit = p;
            cost = (double)profit/ weight;
        }

        public String toString(){return "Cost: " + cost;}

        @Override
        public int compareTo(Thing o) {
            if(o.cost > this.cost) return 1;
            else if(o.cost < this.cost) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        int n = 3; // No of things
        int capacity = 5;
        int profit[] = {10,6,15};
        int weight[] = {2, 3, 5};

        System.out.println("Maximum profit: " + getMaxProfit(capacity, profit, weight, n));
    }

    private static double getMaxProfit(int capacity, int[] profit, int[] weight, int n) {
        ArrayList<Thing> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Thing(weight[i], profit[i]));
        }

        Collections.sort(list);
        double maxProfit = 0.0;

        for(int i = 0; i < n; i++) {
            Thing obj = list.get(i);

            if(obj.weight <= capacity){
                capacity -= obj.weight;
                maxProfit += obj.profit;
            }
            else{
                // obj.w = 5 capacity = 3 => 3/5 times * profit
                maxProfit += (capacity * obj.profit)/obj.weight;
                break;
            }
        }

        return maxProfit;
    }
}
