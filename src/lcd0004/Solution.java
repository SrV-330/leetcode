package lcd0004;

class Solution {
    // O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int flg = (m + n) % 2;
        int mid = 0;
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }
        if (nums1 == null || nums1.length == 0) {
            mid = nums2.length / 2;
            return flg == 0 ? (nums2[mid] + nums2[(mid - 1) < 0 ? 0 : (mid - 1)]) / 2.0 : nums2[mid];
        }
        if (nums2 == null || nums2.length == 0) {
            mid = nums1.length / 2;
            return flg == 0 ? (nums1[mid] + nums1[(mid - 1) < 0 ? 0 : (mid - 1)]) / 2.0 : nums1[mid];
        }
        int len = m + n;
        int i = 0;
        int j = 0;
        int[] arr = new int[2];
        arr[0] = nums1[i];
        arr[1] = nums2[j];

        for (i = 0, j = 0; (i < m || j < n) && i + j < len / 2 + 1; ) {
            if (i >= m) {
                arr[0] = arr[1];
                arr[1] = nums2[j];
                j++;
            } else if (j >= n) {
                arr[0] = arr[1];
                arr[1] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {

                if (i < m) {
                    arr[0] = arr[1];
                    arr[1] = nums1[i];
                    i++;
                } else {
                    if (j < n) {
                        arr[0] = arr[1];
                        arr[1] = nums2[j];
                        j++;
                    }
                }
            } else {
                if (j < n) {
                    arr[0] = arr[1];
                    arr[1] = nums2[j];
                    j++;
                } else {
                    if (i < m) {
                        arr[0] = arr[1];
                        arr[1] = nums1[i];
                        i++;
                    }
                }
            }
        }

        if (flg == 0) {
            return (arr[0] + arr[1]) / 2.0;
        } else {
            return arr[1];
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    //i: nums1的起始位置 j: nums2的起始位置
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }

    public static void main(String[] args) {
        /*System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 1, 3}, new int[]{}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1}, new int[]{}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2, 5}, new int[]{3, 4, 6}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2, 5}, new int[]{3, 4, 6, 7}));
        System.out.println(new Solution().findMedianSortedArrays1(new int[]{1, 1, 3}, new int[]{}));
        System.out.println(new Solution().findMedianSortedArrays1(new int[]{1}, new int[]{}));
        System.out.println(new Solution().findMedianSortedArrays1(new int[]{1, 2, 5}, new int[]{3, 4, 6}));
        System.out.println(new Solution().findMedianSortedArrays1(new int[]{1, 2, 5}, new int[]{3, 4, 6, 7}));*/
        System.out.println(new Solution().findMedianSortedArrays2(new int[]{1}, new int[]{}));
    }
}
