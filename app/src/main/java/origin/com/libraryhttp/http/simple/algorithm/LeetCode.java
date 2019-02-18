package origin.com.libraryhttp.http.simple.algorithm;

import java.util.HashSet;
import java.util.Set;

public class LeetCode {

    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();
        leetCode.lengthOfLongestSubstring("abcabcdd");
    }

    /**
     *求不重复最大字符串长度
     * 解题思路
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    private boolean allUnique(String s, int start, int end) {
        System.out.println("s = [" + s + "], start = [" + start + "], end = [" + end + "]");
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)){
                return false;
            }
            System.out.println("set size = " +set.size());
            set.add(ch);
        }
        return true;
    }
}
