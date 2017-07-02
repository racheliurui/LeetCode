package LeetCode.Problems.LongestPalindromicSubstring;

/**
 * Created by Rachel on 7/2/2017.
 */
public class LongestPalindromicSubstringSolution {
    public String longestPalindrome(String s) {
        String longestString = "";
        int len = s.length();
        int currentPostion = 0;
        String currentString = null;
        while (currentPostion < len) {
            //check if worth doing
            if (getPossibleMaxLengh(currentPostion, len) > longestString.length()) {
                currentString = getMaxPalindromicSubStringAtCurrentPosition(currentPostion, s);
                if (currentString.length() > longestString.length())
                    longestString = currentString;

            }
            currentPostion++;
        }


        return longestString;
    }

    /**
     * possible max length for the Palindromic substring we can get
     **/
    public int getPossibleMaxLengh(int currentPostion, int length) {

        if ((currentPostion + 1) * 2 <= length)
            return (currentPostion + 1) * 2;
        else
            return (length - currentPostion) * 2;

    }

    public String getMaxPalindromicSubStringAtCurrentPosition(int currentPositon, String s) {


        String maxString = s.substring(currentPositon, currentPositon + 1);
        //assuming mirror
        int index1 = currentPositon;
        int index2 = currentPositon + 1;
        int len = s.length();
        if(index2>len-1)
            return s.substring(index1,index1+1);
        while (index1 > 0 && index2 < len - 1 && s.charAt(index1) == s.charAt(index2)) {
            index1--;
            index2++;
        }
        if (s.charAt(index1) == s.charAt(index2)) {
            if (index2 - index1 + 1 > maxString.length())
                maxString = s.substring(index1, index2 + 1);
        } else {
            if (index2 - index1 - 1 > maxString.length())
                maxString = s.substring(index1 +1, index2);
        }


        //assuming flag
        if(currentPositon>0){
            index1 = currentPositon - 1;
            index2 = currentPositon + 1;
            while (index1 > 0 && index2 < len - 1 && s.charAt(index1) == s.charAt(index2)) {
                index1--;
                index2++;
            }
            if (s.charAt(index1) == s.charAt(index2)) {
                if (index2 - index1 + 1 > maxString.length())
                    maxString = s.substring(index1, index2 + 1);
            } else {
                if (index2 - index1 - 1 > maxString.length())
                    maxString = s.substring(index1 +1, index2);
            }
        }

        return maxString;

    }
}
