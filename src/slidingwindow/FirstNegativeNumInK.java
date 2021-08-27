package slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumInK {
    public static void main(String[] args) {
        int arr[] = {-8, 2, 3, -6, 10};
        int j=0, i=0, k = 2;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        while(j < arr.length){
            if(arr[j] < 0)
                q.add(arr[j]);

            if(j-i+1 < k) j++;

            else if(j-i+1 == k){

                if(q.isEmpty()) {
                    list.add(0);
                }
                else list.add(q.peek());

                if(arr[i] < 0)
                    q.poll();

                j++; i++;
            }
        }
        System.out.println("List " + list);
    }
}

