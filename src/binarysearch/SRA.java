package binarysearch;

class SRA
{
    static int findMin(int arr[]){
        int n = arr.length;
        int start = 0, end = n - 1;

        while(start<=end){
            int mid = start + ((end - start)/2);
            int prev = (mid + n - 1)%n;
            int next = (mid + 1) % n;

            if(arr[mid]<arr[prev] && arr[mid] < arr[next] ){
                return mid;
            }

            if(arr[mid] <= arr[end] )
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }


    static int searchElt(int start, int end, int arr[], int elt){

        while(start <= end){
            int mid = start + ((end - start)/2);

            if(arr[mid] == elt)
                return mid;
            if(arr[mid] < elt)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }
    static int Search(int array[], int target)
    {
        int min = findMin(array);
        System.out.println(min);

        int indx1 = searchElt(0, min, array, target);
        int indx2 = searchElt(min, array.length-1, array, target);


        return (indx1 != -1) ? indx1 : indx2;

    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 1,2 };
        System.out.println(Search(arr, 4));
    }
}
