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

    // O(log(m+n))
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }
        if (nums1 == null || nums1.length == 0) {

            return (nums2[nums2.length / 2] + nums2[(nums2.length - 1) / 2]) / 2.0;
        }
        if (nums2 == null || nums2.length == 0) {
            return (nums1[nums1.length / 2] + nums1[(nums1.length - 1) / 2]) / 2.0;
        }
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, endi = m - 1;
        int j = 0, endj = n - 1;
        while (i + j < (m + n) / 2) {
            if (nums1[i] < nums2[j]) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 1, 3}, new int[]{}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1}, new int[]{}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2, 5}, new int[]{3, 4, 6}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2, 5}, new int[]{3, 4, 6, 7}));
        System.out.println(new Solution().findMedianSortedArrays1(new int[]{1, 1, 3}, new int[]{}));
        System.out.println(new Solution().findMedianSortedArrays1(new int[]{1}, new int[]{}));
        System.out.println(new Solution().findMedianSortedArrays1(new int[]{1, 2, 5}, new int[]{3, 4, 6}));
        System.out.println(new Solution().findMedianSortedArrays1(new int[]{1, 2, 5}, new int[]{3, 4, 6, 7}));

    }
}
