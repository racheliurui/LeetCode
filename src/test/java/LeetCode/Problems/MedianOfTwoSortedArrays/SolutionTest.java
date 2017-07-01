package LeetCode.Problems.MedianOfTwoSortedArrays;

import org.junit.Test;

import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by Rachel on 6/19/2017.
 */
public class SolutionTest {
    static Solution q = new Solution();


    public static void main(String[] args) {

        LeetCode.Problems.MedianOfTwoSortedArrays.Solution tester = new LeetCode.Problems.MedianOfTwoSortedArrays.Solution(); // MySolution is tested

        System.out.println(tester.findMedianSortedArrays(new int[]{1, 2, 6,7}, new int[]{3,4,5,8}));
        //  System.out.println(tester.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4}));
//        SolutionTest test = new SolutionTest();
//        double aaa = test.getMedianSortedArrays(new int[]{1,4}, new int[]{2,3});
//        System.out.println(aaa);
//        System.out.println(tester.findMedianSortedArrays(new int[]{1, 4}, new int[]{2, 3}));

    }

    @Test
    public void TestSolution() {
        LeetCode.Problems.MedianOfTwoSortedArrays.Solution tester = new LeetCode.Problems.MedianOfTwoSortedArrays.Solution(); // MySolution is tested

        // assert statements
        assertEquals(3.5, tester.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6}), 0);
        assertEquals(4.5, tester.findMedianSortedArrays(new int[]{1, 2, 5}, new int[]{4, 5, 6}), 0);
        assertEquals(3, tester.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{3, 5, 6}), 0);
        assertEquals(5, tester.findMedianSortedArrays(new int[]{5, 5, 5}, new int[]{5, 5, 5}), 0);

        assertEquals(3, tester.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5}), 0);
        assertEquals(3, tester.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{7, 8}), 0);
        assertEquals(2, tester.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{1, 2}), 0);

        assertEquals(2.5, tester.findMedianSortedArrays(new int[]{2, 3, 4}, new int[]{1}), 0);
        assertEquals(2.5, tester.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}), 0);

        assertEquals(3, tester.findMedianSortedArrays(new int[]{4, 5}, new int[]{1, 2, 3}), 0);
        assertEquals(3, tester.findMedianSortedArrays(new int[]{7, 8}, new int[]{1, 2, 3}), 0);
        assertEquals(2, tester.findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2, 3}), 0);

        assertEquals(1, tester.findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 2}), 0);
        assertEquals(1, tester.findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 1}), 0);
        assertEquals(1, tester.findMedianSortedArrays(new int[]{1}, new int[]{1}), 0);


        assertEquals(2.5, tester.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}), 0);
        assertEquals(2, tester.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0);
        assertEquals(3, tester.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 5, 8}), 0);
        assertEquals(2, tester.findMedianSortedArrays(new int[]{1, 3}, new int[]{}), 0);

        assertEquals(3, tester.findMedianSortedArrays(new int[]{1, 3, 3}, new int[]{}), 0);
        assertEquals(2, tester.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{}), 0);

        assertEquals(3, tester.findMedianSortedArrays(new int[]{}, new int[]{1, 3, 3}), 0);
        assertEquals(2, tester.findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3}), 0);

        assertEquals(3, tester.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4, 5}), 0);

        assertEquals(2.5, tester.findMedianSortedArrays(new int[]{1, 4}, new int[]{2, 3}), 0);

      assertEquals(3.5, tester.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4,5,6}), 0);
        assertEquals(3, tester.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4,5}), 0);
        assertEquals(3, tester.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2,5}), 0);
        assertEquals(3.5, tester.findMedianSortedArrays(new int[]{1, 2,5}, new int[]{3, 4,6}), 0);
        assertEquals(4.5, tester.findMedianSortedArrays(new int[]{1, 2,6,7}, new int[]{3, 4,5,8}), 0);


    }


    @Test
    public void OddOdd() {
        //1,1
        Assert.assertEquals(1.5, q.findMedianSortedArrays(new int[]{1}, new int[]{2}), 0);
        Assert.assertEquals(2, q.findMedianSortedArrays(new int[]{2}, new int[]{2}), 0);
        Assert.assertEquals(2.5, q.findMedianSortedArrays(new int[]{3}, new int[]{2}), 0);

        //1,3 & 3,1
        int[][] base = new int[][]{{5, 5, 5}, {5, 5, 10}, {2, 5, 5}, {2, 5, 10}};
        int[][] target = new int[][]{{}, {}, {}, {}, {}, {}, {}};
        for (int i = 0; i < 4; i++) {
            target[0] = new int[]{base[i][0] - 1};
            target[1] = new int[]{base[i][0]};
            target[2] = new int[]{base[i][0] + 1};
            target[3] = new int[]{base[i][1]};
            target[4] = new int[]{base[i][1] + 1};
            target[5] = new int[]{base[i][2]};
            target[6] = new int[]{base[i][2] + 1};
            for (int j = 0; j < 7; j++) {
                printTestCase(base[i], target[j]);
                Assert.assertEquals(getMedianSortedArrays(base[i], target[j]), q.findMedianSortedArrays(base[i], target[j]), 0);
                printTestCase(target[j], base[i]);
                Assert.assertEquals(getMedianSortedArrays(target[j], base[i]), q.findMedianSortedArrays(target[j], base[i]), 0);
            }
        }


    }

    @Test
    public void OddEven() {


    }

    @Test
    public void EvenEven() {
        Assert.assertEquals(2.5, q.findMedianSortedArrays(new int[]{}, new int[]{2, 3}), 0);
        Assert.assertEquals(2.5, q.findMedianSortedArrays(new int[]{2, 3}, new int[]{}), 0);

        Assert.assertEquals(1, q.findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 2}), 0);
        Assert.assertEquals(1, q.findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 1}), 0);


    }


    //slow but trustworthy
    private double getMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergedNums = 0;
        if ((nums1.length + nums2.length) % 2 == 0) {
            //even
            int targetNums = (nums1.length + nums2.length) / 2;
            if (nums1.length == 0 || nums2.length == 0) {
                if (nums1.length == 0)
                    return new Float((nums2[targetNums] + nums2[targetNums - 1]) / 2).floatValue();
                else
                    return new Float((nums1[targetNums] + nums1[targetNums - 1]) / 2).floatValue();
            } else {
                int index1 = -1;
                int index2 = -1;
                boolean pointerNums1 = true;
                while (mergedNums < targetNums) {
                    if (index1 == nums1.length - 1) {
                        index2++;
                        pointerNums1 = false;
                    } else if (index2 == nums2.length - 1) {
                        index1++;
                        pointerNums1 = true;
                    } else if (nums1[index1 + 1] <= nums2[index2 + 1]) {
                        index1++;
                        pointerNums1 = true;
                    } else {
                        index2++;
                        pointerNums1 = false;
                    }
                    mergedNums++;
                }
                //mergedNums==targetNums
                if (pointerNums1) {

                    //stoped at nums1
                    if (index1 + 1 == nums1.length)
                        return new Double((nums1[index1] + nums2[index2 + 1])) / 2;
                    else {
                        if (index2 + 1 == nums2.length)
                            return new Double(nums1[index1] + nums1[index1 + 1]) / 2;
                        else {
                            return new Double(nums1[index1] + ((nums1[index1 + 1] <= nums2[index2 + 1]) ? nums1[index1 + 1] : nums2[index2 + 1])) / 2;
                        }
                    }

                } else {
                    if (index1 + 1 == nums1.length)
                        return new Double((nums2[index2] + nums2[index2 + 1])) / 2;
                    else {

                        if (index2 + 1 == nums2.length)
                            return new Double(nums2[index2] + nums1[index1 + 1]) / 2;
                        else
                            return new Double((nums2[index2] + ((nums1[index1 + 1] <= nums2[index2 + 1]) ? nums1[index1 + 1] : nums2[index2 + 1]))) / 2;


                    }
                }
            }

            //odd
        } else {
            int targetNums = (nums1.length + nums2.length + 1) / 2;
            if (nums1.length == 0 || nums2.length == 0) {
                if (nums1.length == 0)
                    return nums2[targetNums - 1];
                else
                    return nums1[targetNums - 1];
            } else {
                int index1 = -1;
                int index2 = -1;
                boolean pointerNums1 = true;
                while (mergedNums < targetNums) {
                    if (nums1[index1 + 1] <= nums2[index2 + 1]) {
                        index1++;
                        pointerNums1 = true;
                    } else {
                        index2++;
                        pointerNums1 = false;
                    }
                    mergedNums++;
                }
                if (pointerNums1)
                    return nums1[index1];
                else
                    return nums2[index2];
            }

        }

    }

    private void printTestCase(int[] nums1, int[] nums2) {
        String testcase = "TestCase: {";
        for (int num : nums1) {
            testcase = testcase + num + ",";
        }
        testcase = testcase + "}, {";
        for (int num : nums2) {
            testcase = testcase + num + ",";
        }
        testcase = testcase + "}";
        System.out.println(testcase);
    }
}
