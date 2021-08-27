package binarysearch;

//First and last Occurrence of an element in an array
public class FirstAndLastOccurrence {
    public static void main(String[] args) {

        int arr[] = {2, 4, 10, 10, 10, 30};
        int elt = 10;

        int first = findFirstOccurrence(arr, elt);
        int last = findLastOccurrence(arr, elt);

        //count of occurrence
        int count = last - first + 1;
        System.out.println(count + " num of times " + elt + " is repeated.");

    }
//  Find last occurrence
    private static int findLastOccurrence(int[] arr, int elt) {
        int start = 0, end = arr.length - 1;
        int last = -1;

        while (start <= end) {

            int mid = start + ((end - start)/2);

            if(arr[mid] == elt){
                last = mid;
                start = mid + 1;
            }
            if(arr[mid] > elt)
                end = mid - 1;
            else start = mid + 1;
        }

        System.out.println("Last occurrence of " + elt + " is " + last);
        return last;

    }

    private static int  findFirstOccurrence(int[] arr, int elt) {
        int start = 0, end = arr.length - 1;
        int first = -1;

        while (start <= end) {

            int mid = start + ((end - start)/2);

            if(arr[mid] == elt){
                first = mid;
                end = mid - 1;
            }
            if(arr[mid] > elt)
                end = mid - 1;
            else start = mid + 1;
        }

        System.out.println("First occurrence of " + elt + " is " + first);
        return first;

    }
}
