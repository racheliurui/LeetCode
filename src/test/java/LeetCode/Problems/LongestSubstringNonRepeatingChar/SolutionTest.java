package LeetCode.Problems.LongestSubstringNonRepeatingChar;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Rachel on 6/19/2017.
 */
public class SolutionTest {
    @Test
    public void TestSolution() {
        LeetCode.Problems.LongestSubstringNonRepeatingChar.Solution tester = new LeetCode.Problems.LongestSubstringNonRepeatingChar.Solution(); // MySolution is tested

        // assert statements
        assertEquals(tester.lengthOfLongestSubstring("abcabc"), 3);
        assertEquals(tester.lengthOfLongestSubstring("aabcdefgg"), 7);

    }
}
