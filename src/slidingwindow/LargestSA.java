package slidingwindow;

// Largest sub array of given sum ==> variable size window
public class LargestSA {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1,1,1};
        int k = 3;
        findMaxLength(arr, k);
    }

    private static void findMaxLength(int[] arr, int k) {
        int i=0, j=0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        while(j < arr.length){
            sum += arr[j];

            if(sum < k) j++;

            else if(sum == k){
                max = Math.max(max, j-i+1);
                j++;
            }

            else if(sum > k){
                while(sum > k){
                    sum -= arr[i];
                    i++;
                }
                j++;
            }
        }
        System.out.println(max);
    }
}