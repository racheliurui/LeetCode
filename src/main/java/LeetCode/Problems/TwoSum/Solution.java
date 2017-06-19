package LeetCode.Problems.TwoSum;
import java.util.HashMap;
/**
 * Created by Rachel on 6/19/2017.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] found = new int[2];
        HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
        int differece;
        for (int i=0; i<nums.length; i++){
            differece = target - nums [i];
            if (result.containsKey(new Integer(nums [i])))
                return new int[]{i,result.get(new Integer(nums [i])).intValue()};
            else
                result.put(new Integer(differece), new Integer(i));
        }

        return null;
    }
}
