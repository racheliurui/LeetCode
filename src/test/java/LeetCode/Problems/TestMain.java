package LeetCode.Problems;


import LeetCode.Problems.LongestPalindromicSubstring.LongestPalindromicSubstringSolution;
import LeetCode.Problems.LongestPalindromicSubstring.LongestPalindromicSubstringSolution_TimeExceeded1;
import org.junit.Assert;

/**
 * Created by Rachel on 6/18/2017.
 */
public class TestMain {
    public static void main(String[] args) {

        //  LongestPalindromicSubstringSolution_TimeExceeded1 s = new LongestPalindromicSubstringSolution_TimeExceeded1(); // MySolution is tested
        //  s.longestPalindrome("a");
        LongestPalindromicSubstringSolution solution = new LongestPalindromicSubstringSolution();
        Assert.assertEquals("sample test case", "a", solution.longestPalindrome("a"));


    }

}
