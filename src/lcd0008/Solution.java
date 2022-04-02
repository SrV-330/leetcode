package lcd0008;

public class Solution {
    public int myAtoi(String s) {

        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int i = 0;
        long res = 0;
        boolean numFlag = false;
        boolean symbolFlag = false;
        boolean nagFlag = false;
        while (i < chars.length && (!symbolFlag
                || symbolFlag && (chars[i] <= '9' && chars[i] >= '0'
                ))) {
            if (chars[i] == ' ' || chars[i] == '.') {
                i++;
                continue;
            }
            if (symbolFlag && (chars[i] == '+' || chars[i] == '-')) {
                nagFlag = chars[i] == '+';
                numFlag = true;
                symbolFlag = true;
                i++;
                continue;
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                res = res * 10 + chars[i] - '0';
                symbolFlag = true;
                i++;
                continue;
            }
            i++;
        }
        if (!nagFlag) res = -res;
        return (int) res == res ? (int) res : res > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new Solution().myAtoi("asda-2344.87 "));
    }
}
