package lcd0005;

public class Solution {
    public String longestPalindrome(String s) {

        if (s == null) return "";
        int len = s.length();
        if (len == 0) return "";
        int p = 0, q = 0;
        int maxLen = 0;
        int[] res = {0, 1};
        for (int i = 0; i < len; i++) {
            p = i;
            q = i;
            while (p >= 0 && q < len && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
            }
            p++;
            q--;
            if (maxLen < q - p + 1) {
                res[0] = p;
                res[1] = q + 1;
                maxLen = q - p + 1;
            }
            p = i;
            q = i + 1;
            while (p >= 0 && q < len && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
            }
            p++;
            q--;
            if (maxLen < q - p + 1) {
                res[0] = p;
                res[1] = q + 1;
                maxLen = q - p + 1;
            }
        }

        return s.substring(res[0],res[1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("asddsa"));
        System.out.println(new Solution().longestPalindrome("b"));
        System.out.println(new Solution().longestPalindrome(""));
        System.out.println(new Solution().longestPalindrome("bbbbbb"));
        System.out.println(new Solution().longestPalindrome("asdsdsa"));
        System.out.println(new Solution().longestPalindrome("asdsdsasdsd"));
        System.out.println(new Solution().longestPalindrome("babad"));
    }
}
