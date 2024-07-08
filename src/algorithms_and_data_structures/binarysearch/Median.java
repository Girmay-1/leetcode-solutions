package algorithms_and_data_structures.binarysearch;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 */
public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // [ 2, 3, 4]
        // [ 7 8 9 10 11]

        // [2, 3, 4, 7, 8, 9, 10, 11]
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int halfLen = (m + n + 1)/2; //reason for adding 1 is to account for both odd and even numbers.[ note if odd we are looking at the element next to the median and if even, we are looking at the second element of the two in the middle]
        int minIndex = 0;
        int maxIndex = m;
        while(minIndex <= maxIndex){
            int i = (minIndex + maxIndex)/ 2;
            int j = halfLen - i;

            if( i < maxIndex && nums2[j - 1] > nums1[i]){
                minIndex = i + 1; // i is too small;
            }else if( i > minIndex && nums2[j] < nums1[i - 1]){
                maxIndex = i - 1; // i is too big;
            }else{
                int maxLeft = 0;
                if(i == 0){
                    maxLeft = nums2[j - 1];
                }else if(j == 0){
                    maxLeft = nums1[i - 1];
                }else{
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if((n + m) % 2 == 1){
                    return maxLeft;
                }else{
                    int minRight = 0;
                    if(i == m){
                        minRight = nums2[j];
                    }else if( j == n){
                        minRight = nums1[i];
                    }else{
                        minRight = Math.min(nums1[i] , nums2[j]);
                    }
                    return (minRight + maxLeft) / 2.0;
                }
            }
        }
        return 0.0; // array are empty
    }
    public static void main(String[] args) {
        Median median = new Median();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + median.findMedianSortedArrays(nums1, nums2)); // Expected output: 2.0

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println("Median: " + median.findMedianSortedArrays(nums1, nums2)); // Expected output: 2.5

        nums1 = new int[]{0, 0};
        nums2 = new int[]{0, 0};
        System.out.println("Median: " + median.findMedianSortedArrays(nums1, nums2)); // Expected output: 0.0

        nums1 = new int[]{};
        nums2 = new int[]{1};
        System.out.println("Median: " + median.findMedianSortedArrays(nums1, nums2)); // Expected output: 1.0

        nums1 = new int[]{2};
        nums2 = new int[]{};
        System.out.println("Median: " + median.findMedianSortedArrays(nums1, nums2)); // Expected output: 2.0
    }

}
