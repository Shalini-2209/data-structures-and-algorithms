package greedy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUImplementation {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static Queue<Integer> q = new LinkedList<>();
    static int cache = 2;

    public static void main(String[] args) {
        LRUImplementation lru = new LRUImplementation();

        // Writing page content
        lru.put(1, 10);
        lru.put(2, 20);
        lru.put(3, 40);

        // Reading page content
        lru.get(2);
        lru.get(3);

        // Updating page content
        lru.put(2, 60);
        lru.get(2);

        System.out.println("Final Cache\n" + q);
    }

    private void get(int pageNo) {

        if (map.containsKey(pageNo)) {
            updateCache(pageNo);
            System.out.println("Page " + pageNo + " has " + map.get(pageNo));
        }
        else System.out.println("404 Page not found");
    }

    private void updateCache(int pageNo) {
        if(q.contains(pageNo)){
            q.remove(pageNo);
            q.add(pageNo);
        }

        // If not, poll the oldest page and add the new page in the cache
        else{
            q.add(pageNo);
            if(q.size() > cache) {
                int pg = q.poll();
                map.remove(pg);
            }
        }
    }

    private void put(int pageNo, int value) {
        updateCache(pageNo);
        map.put(pageNo, value);
    }
}
