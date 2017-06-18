package LeetCode.Problems.AddTwoNumbers;

import LeetCode.Problems.AddTwoNumbers.*;
/**
 * Created by Rachel on 6/18/2017.
 */
public class TestMain {
    public static void main(String [] args)
    {
        Solution solution = new Solution();

        ListNode l1= new ListNode(new int[]{2,4,3});
        ListNode l2 = new ListNode(new int[]{5,6,4});
        System.out.println("list 1 is " + l1.ToString());
        System.out.println("list 2 is " +l2.ToString());

        ListNode result = solution.addTwoNumbers(new ListNode(new int[]{2,4,3}), new ListNode(new int[]{5,6,4}));

        System.out.println(result.ToString());


    }

}
