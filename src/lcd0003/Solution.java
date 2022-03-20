package lcd0003;


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.isEmpty()) return 0;
        if(s.length()==1) return 1;
        int i = 0, j = 1, k = 0;
        int res = 0;
        int flg = -1;
        while ((s.length() - i) >= res && j < s.length()) {
            k = j;
            String s1 = s.substring(i, j);
            flg = -1;
            for (int i1 = 0; i1 < s1.length(); i1++) {
                if (s1.charAt(i1) == s.charAt(k)) {
                    flg = i1 + i;
                    break;
                }
            }
            if (flg != -1) {
                i = flg + 1;
            } else {
                j++;
            }
            res = j - i  > res ? j - i  : res;
        }
        return res;


    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("as"));
    }
}
/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128]; // 记录字符上一次出现的位置
        for(int i=0;i < 128; i++){
            last[i]=-1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i< n; i ++){
            int index = s.charAt(i);
            start = Math.max (start, last[index]+1);
            res = Math.max(res, i-start + 1);
            last[index] = i;
        }
        return res;
    }
}*/

