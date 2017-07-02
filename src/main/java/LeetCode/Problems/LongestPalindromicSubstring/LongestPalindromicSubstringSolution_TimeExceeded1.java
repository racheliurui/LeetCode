package LeetCode.Problems.LongestPalindromicSubstring;

/**
 * Created by Rachel on 7/2/2017.
 */
public class LongestPalindromicSubstringSolution_TimeExceeded1 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int longest_len = len;
        while (longest_len > 0) {
            //found at current length
            String target = getPalindromicSubstring(longest_len, s);
            if (target != null)
                return target;
            //not found at current lengh
            longest_len--;
        }
        //not found, then return any char from s

        return s.substring(0,1);
    }

    /**
     * looking for Palidromic substring with lengh = len from s
     * if not found, return null
     **/
    public String getPalindromicSubstring(int len, String s) {
        //get all the substring with length len
        int s_len = s.length();
        int beginIndex = 0;
        String currentString = null;
        while (beginIndex + len <= s_len) {
            currentString = s.substring(beginIndex, beginIndex + len );
            //check current substring
            if (isPalindromicString(currentString))
                return currentString.toString();
            beginIndex++;
        }
        return null;
    }

    public boolean isPalindromicString(String s) {
        int len = s.length();
        int index1 = 0;
        int index2 = len - 1;

        while (index1 <= index2) {
            if (s.charAt(index1) != s.charAt(index2))
                return false;
            else {
                index1++;
                index2--;
            }
        }
        return true;

    }
}
