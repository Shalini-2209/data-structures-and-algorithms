package greedy;

import java.util.*;

class Process implements Comparable<Process>{
    int id;
    int arrival; // Arrival time
    int burstTime;

    Process(int n, int t1, int t2){
        id = n;
        arrival = t1;
        burstTime = t2;
    }

    @Override
    public int compareTo(Process o) {
        // Based on arrival time..
        if(this.arrival == o.arrival)
            return this.burstTime - o.burstTime;
        else return this.arrival - o.arrival;
    }

    @Override
    public String toString(){
        return "Process " + id  ;
    }
}

public class SJF {

    public static void main(String[] args) {

        List<Process> list = new ArrayList<>();

        list.add(new Process(1, 2, 3));
        list.add(new Process(2, 0, 4));
        list.add(new Process(3, 4, 2));
        list.add(new Process(4, 5, 4));
        list.add(new Process(5, 5, 2));

        Collections.sort(list);

        executeProcess(list);
    }

    private static void executeProcess(List<Process> list) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Process> pq = new PriorityQueue<>(new Comparator<Process>(){
            // Based on Burst time
            @Override
            public int compare(Process o1, Process o2) {
                if(o1.burstTime == o2.burstTime) return o1.id - o2.id;
                return o1.burstTime - o2.burstTime;
            }
        }
        );

        pq.add(list.get(0));

        int executionTime = 0, i = 1;

       while (!pq.isEmpty()){
           Process start = pq.poll();

           executionTime += start.burstTime;

           res.add(start.id);

           while(i < list.size() && list.get(i).arrival <= executionTime){
               pq.add(list.get(i));
               i++;
           }
       }

        System.out.println("Order of execution: " + res);
    }

}
