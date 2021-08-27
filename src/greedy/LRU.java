package greedy;

import java.util.LinkedList;
import java.util.Queue;

public class LRU {
    public static void main(String[] args) {
        int req[] = {1, 2, 3, 4, 1, 3};  // Page requests
        int cache = 3;  // Length of cache

        findPageFaults(req, cache);
    }

    private static void findPageFaults(int[] req, int cache) {
        Queue<Integer> q = new LinkedList<>();
        int faults = 0;

        for (int i = 0; i < req.length; i++) {
            // If page is found in cache, make it as the least recently used
            if(q.contains(req[i])){
                q.remove(req[i]);
                q.add(req[i]);
            }

            // If not, poll the oldest page and add the new page in the cache
            else{
                q.add(req[i]);
                if(q.size() > cache)
                    q.poll();
                faults += 1;
            }
        }
        System.out.println("Total number of page faults: " + faults);
    }
}
