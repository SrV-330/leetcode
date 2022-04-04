package lcd0009;

public class Solution {


    static final int[] table = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int size = 0;
        int i = 0;
        for (; i < table.length; i++) {
            if (x <= table[i]) {
                size = i + 1;
                break;
            }
        }

        i = 0;

        if (size == 1) return true;
        int t = 0;
        for (; i < size / 2; i++) {
            if (x / (int) Math.pow(10, i) % 10 != x / (int) Math.pow(10, size - 1 - i) % 10) {
                return false;
            }
        }
        return true;

    }

    public boolean isPalindrome1(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(0));
        System.out.println(new Solution().isPalindrome(12331));
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(Integer.MIN_VALUE));
        System.out.println(new Solution().isPalindrome(Integer.MAX_VALUE));
    }
}
