package lcd0006;

public class Solution {

    // P A Y P A L I S H I  R  I  N  G
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13
    // P I N A L S I G Y A  H  R  P  I
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13

    /**
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * <p>
     * 0     6        12
     * 1   5 7     11 13
     * 2 4   8  10
     * 3     9
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        if (s == null || s.length() == 0) return "";
        int charsi = 0;
        //String res = "";
        char[] chars = new char[s.length()];
        for (int i = 0; i < numRows; i++) {
            int k = 0;
            for (int j = i; j < s.length(); k++, j = i + (2 * numRows - 2) * k) {
                //res += s.charAt(j);
                chars[charsi++] = s.charAt(j);
                if (i != 0 && i != numRows - 1) {
                    int idx = (2 * numRows - 2) + j - i * 2;
                    if (idx >= s.length()) continue;
                    //res += s.charAt(idx);
                    chars[charsi++] = s.charAt(idx);
                }
            }


        }
        //return res;
        return new String(chars);
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().convert("asdfghjkl", 3));
        System.out.println(new Solution().convert("PAYPALISHIRING", 4));
        //System.out.println(new Solution().convert("asdfghjklqwertyuio", 4));
    }
}
