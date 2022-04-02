package lcd0008;

public class Solution {
    static final char[] MAX = {'2', '1', '4', '7', '4', '8', '3', '6', '4', '7'};
    static final char[] MIN = {'2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};

    public int myAtoi(String s) {

        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int i = 0;
        int start = 0;
        int end = 0;
        boolean nagFlag = true;
        for (; i < chars.length && chars[i] == ' '; i++) ;// 跳过空格
        while (i < chars.length) {
            if (chars[i] == '+' || chars[i] == '-' || chars[i] >= '0' && chars[i] <= '9') {// 找正负号或数字
                nagFlag = chars[i] != '-';// 记录正负
                if (chars[i] == '+' || chars[i] == '-') i++;// 找数字
                for (; i < chars.length && chars[i] == '0'; i++) ;// 跳过0
                start = i;// 数字头
                for (; i < chars.length && chars[i] <= '9' && chars[i] >= '0'; i++) ;
                end = i;// 数字尾
                if (end > chars.length) return 0;
                if (end - start > 10) {// 比int位数大
                    return nagFlag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else if (end - start == 10) {// 和int位数一样,比大小

                    char[] charT = nagFlag ? MAX : MIN;// 和int最大最小值比大小
                    for (int j = 0; j < charT.length; j++) {
                        if (charT[j] < chars[start + j]) {
                            return nagFlag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        } else if (charT[j] == chars[start + j]) {
                            continue;
                        } else {
                            int res = 0;
                            for (int k = start; k < end; k++) {
                                res = res * 10 + chars[k] - '0';
                            }
                            return nagFlag ? res : -res;
                        }
                    }

                    return nagFlag ? Integer.MAX_VALUE : Integer.MIN_VALUE;

                } else {
                    int res = 0;
                    for (int j = start; j < end; j++) {
                        res = res * 10 + chars[j] - '0';
                    }
                    return nagFlag ? res : -res;
                }
            }else{
                break;
            }
        }
        return 0;
    }

    public int myAtoi1(String s) {
        int len = s.length(), ans = 0;
        int i = 0;
        while (i < len && s.charAt(i) == ' ') i++;
        int start = i;
        int flag = 1;
        for (; i < len; i++) {
            char c = s.charAt(i);
            if (i == start && c == '+') flag = 1;
            else if (i == start && c == '-') flag = -1;
            else if (Character.isDigit(c)) {
                int temp = c - '0';
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10) && temp > 7)
                    return Integer.MAX_VALUE;
                if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10) && temp > 8)
                    return Integer.MIN_VALUE;
                ans = ans * 10 + temp * flag;
            } else {
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new Solution().myAtoi("   -2344.87as FDFSDA "));
        System.out.println(new Solution().myAtoi("   -2147483648aa.87as FDFSDA "));
        System.out.println(new Solution().myAtoi("   -0002147483648aa.87as FDFSDA "));
        System.out.println(new Solution().myAtoi("   +0002147483648aa.87as FDFSDA "));
        System.out.println(new Solution().myAtoi("   ++02147483647.87as FDFSDA "));
        System.out.println(new Solution().myAtoi("   +002147483647.87as FDFSDA "));
        System.out.println(new Solution().myAtoi("   2147483647.87as FDFSDA "));
        System.out.println(new Solution().myAtoi("  9223372036854775808"));
        System.out.println(new Solution().myAtoi("42"));
        System.out.println(new Solution().myAtoi("  asdasd 42"));
        System.out.println(new Solution().myAtoi("  -42"));
    }
}
