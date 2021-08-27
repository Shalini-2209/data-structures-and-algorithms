package binarysearch;

public class NextAlphabet {
    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c', 'f', 'h'};
        //ceil value
        int start = 0, end = arr.length - 1;
        int  elt = 'f';
        int res = 0;


        while(start <= end){
            int mid = start + ((end - start)/2);

            if(elt < arr[mid]){
                res = arr[mid];
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        System.out.println((char)res);
    }
}
