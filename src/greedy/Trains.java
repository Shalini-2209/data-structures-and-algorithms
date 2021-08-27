package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Trains
{
    static class Node implements Comparable<Node>{
        int arr;
        int dept;

        Node(int a, int d){
            arr = a;
            dept = d;
        }

        public String toString(){
            return " " + arr + " - " + dept;
        }
        public int compareTo(Node o){
            return this.arr - o.arr;
        }
    }

    static ArrayList<Node> list = new ArrayList<>();
    static int findPlatform(int arr[], int dep[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int pf = 1;

        for(int i=0; i<n; i++){
            list.add(new Node(arr[i], dep[i]));
        }

        map.put(1, list.get(0).dept);
        System.out.println(list);

        for(int i=1; i<n; i++){
            int a = list.get(i).arr;
            int d = list.get(i).dept;

            if(a > map.get(pf)){
                map.put(pf, d);
                continue;
            }
            else if(a < map.get(pf)){
                if(pf == 1) {map.put(pf+1, d); pf++;
                  }
                else if(pf > 1){
                    int cyc = pf-1;
                    while(cyc > 0 && a < map.get(cyc) ){
                        cyc--;
                    }

                    if(cyc <= 0)
                    {
                        map.put(pf + 1, d);
                        pf++;
                    }
                    else map.put(cyc, d);
                }
            }
        }

        return pf;

    }

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

//        int arr[] = {900, 1100, 1235};
//        int dep[] = {1000, 1200, 1240};

        System.out.println(findPlatform(arr, dep, 6));
    }
}
