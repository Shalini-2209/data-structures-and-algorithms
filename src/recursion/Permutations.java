package recursion;

public class Permutations {
    public static void main(String[] args) {
        int n = 3;
        int arr[] = new int[n];
//        int range[] = new int[]
        print(4, 6, arr,0);
        StringBuilder op = new StringBuilder("");

    }

    private static void print(int start, int end, int[] arr ,int index) {
        if(index == arr.length) {
            for(int j:arr)  System.out.print(j);
            System.out.println();
            return;
        }
        if(index>arr.length)return;
        for(int i=start;i<=end;i++) {
            if(arr[index]!=0)continue;
            arr[index]=i;
            print(start,end ,arr,index+1);
            arr[index]=0;
        }
    }
}
