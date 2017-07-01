package LeetCode.Problems.MedianOfTwoSortedArrays;


public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 0) {
            if (m < n)
                return findMedianTotalEven(m, n, nums1, nums2);
            else
                return findMedianTotalEven(n, m, nums2, nums1);

        } else {
            if (m % 2 == 0)
                return findMedianOddEven(n, m, nums2, nums1);
            else
                return findMedianOddEven(m, n, nums1, nums2);
        }


    }


    /**
     * m+n is even
     **/
    public double findMedianTotalEven(int m, int n, int[] nums1, int[] nums2) {
        int index1;
        int index2;
        if (m % 2 == 0) {
            index1 = m / 2;
            index2 = (n - 1) / 2;
            if (index2 < 0)
                return -1; //non existing situation
            if (index1 == 0)
                return new Double(nums2[index2] + nums2[index2 + 1]) / 2;
        } else {
            index1 = (m - 1) / 2;
            index2 = (n - 1) / 2;
        }

        if (nums1[index1] > nums2[index2]) {

            //nums1 safely shift right
            while ((index2 + 1 < n) && (index1 > 0) && nums1[index1] > nums2[index2 + 1]) {
                index1--;
                index2++;
            }
            while ((index2 + 1 < n) && (index1 > 0) && nums2[index2] < nums1[index1 - 1]) {
                index1--;
                index2++;
            }
        } else {
            //nums1 safely shift left
            while ((index1 + 1 < m) && (index2 > 0) && nums1[index1] < nums2[index2 - 1]) {
                index1++;
                index2--;
            }
            while ((index1 + 1 < m) && (index2 > 0) && nums2[index2] > nums1[index1 + 1]) {
                index1++;
                index2--;
            }
        }
        /**
         * currently index1 and index2 are either find their best place or moved to edge
         * currently  num of nums at left side and right side are equal,
         * if index1 and index2 are not pointing to edge, then means the target num found.
         * else, we should find the central two from the small group of nums
         * **/
        if (index1 > 0 && index2 > 0 && index1 + 1 < m && index2 + 1 < n) {
            if (nums1[index1 - 1] < nums2[index2 - 1]) {
                if (nums1[index1 + 1] < nums2[index2 + 1])
                    return findMidianTwoFromTwoTwo(new Double(nums1[index1]), new Double(nums1[index1 + 1]), new Double(nums2[index2 - 1]), new Double(nums2[index2]));
                else
                    return findMidianTwoFromThreeOne(new Double(nums2[index2 - 1]), new Double(nums2[index2]), new Double(nums2[index2 + 1]), new Double(nums1[index1]));
            } else {
                //nums1[index1 - 1] >= nums2[index2]
                if (nums1[index1 + 1] < nums2[index2 + 1])
                    return findMidianTwoFromThreeOne(new Double(nums1[index1 - 1]), new Double(nums1[index1]), new Double(nums1[index1 + 1]), new Double(nums2[index2]));
                else
                    return findMidianTwoFromTwoTwo(new Double(nums1[index1 - 1]), new Double(nums1[index1]), new Double(nums2[index2]), new Double(nums2[index2 + 1]));
            }


        } else {
            return findMidianTwoFromSix((index1 == 0) ? null : new Double(nums1[index1 - 1]), new Double(nums1[index1]), (index1 + 1 == m) ? null : new Double(nums1[index1 + 1]),
                    (index2 == 0) ? null : new Double(nums2[index2 - 1]), new Double(nums2[index2]), (index2 + 1 == n) ? null : new Double(nums2[index2 + 1]));
        }


    }

    /**
     * m is odd , n is even
     **/
    public double findMedianOddEven(int m, int n, int[] nums1, int[] nums2) {
        int index1 = (m - 1) / 2;
        int index2 = n / 2;

        if (index2 == 0)
            return nums1[index1];

        if (nums1[index1] > nums2[index2]) {
            //nums1 safely shift right
            while ((index2 + 1 < n) && (index1 > 0) && nums1[index1] > nums2[index2]) {
                index1--;
                index2++;
            }
        } else {
            //nums1 safely shift left
            while ((index1 + 1 < m) && (index2 > 0) && nums1[index1] < nums2[index2 - 1]) {
                index1++;
                index2--;
            }

        }

        if (index2 == 0)
            return (nums1[index1] > nums2[index2] ? nums2[index2] : nums1[index1]);
        else {
            if (nums1[index1] < nums2[index2 - 1]) {
                if (index1 + 1 < m)
                    return (nums1[index1 + 1] > nums2[index2 - 1] ? nums2[index2 - 1] : nums1[index1 + 1]);
                else
                    return nums2[index2 - 1];
            } else if (nums1[index1] > nums2[index2]) {
                if (index1 > 0)
                    return (nums1[index1 - 1] > nums2[index2] ? nums1[index1 - 1] : nums2[index2]);
                else
                    return nums2[index2];
            } else
                return nums1[index1];
        }
    }

    public double findMidianTwoFromSix(Double A1, Double A2, Double A3, Double B1, Double B2, Double B3) {
        //if A1 == null then cross out max num from right
        if (A1 == null) {
            if (B1 == null) {
                return (A2 + B2) / 2;
            } else {
                //A1==null and B1!=null
                if (A3 == null) {
                    // A3==null
                    return findMidianTwoFromThreeOne(B1, B2, B3, A2);
                } else {
                    // A3 !=null
                    if (B3 != null) {
                        if (B3 > A3)
                            return findMidianTwoFromTwoTwo(A2, A3, B1, B2);
                        else
                            return findMidianTwoFromThreeOne(B1, B2, B3, A2);
                    } else {
                        //B3==null
                        return findMidianTwoFromTwoTwo(A2, A3, B1, B2);
                    }
                }
            }
        } else {
            //A1!=null
            if (B1 == null) {
                if (B3 == null) {
                    //A1!=null and B1==null and B3==null
                    return findMidianTwoFromThreeOne(A1, A2, A3, B2);
                } else {
                    //A1!=null and B1==null and B3!=null
                    if (A3 == null) {
                        // A1!=null and B1==null and B3!=null & A3==null
                        return findMidianTwoFromTwoTwo(A1, A2, B2, B3);
                    } else {
                        // A1!=null and B1==null and B3!=null and A3!=null
                        if (A3 > B3)
                            return findMidianTwoFromTwoTwo(A1, A2, B2, B3);
                        else
                            return findMidianTwoFromThreeOne(A1, A2, A3, B2);
                    }
                }
            } else {
                if (B3 == null) {
                    //A1!=null and B1!=null and B3==null ==>A3!=null
                    if (A1 < B1)
                        return findMidianTwoFromTwoTwo(A2, A3, B1, B2);
                    else
                        return findMidianTwoFromThreeOne(A1, A2, A3, B2);

                } else {
                    // A1!=null and B1!=null and B3!=null ==>A3 ==null
                    if (A1 < B1)
                        return findMidianTwoFromThreeOne(B1, B2, B3, A2);
                    else
                        return findMidianTwoFromTwoTwo(A1, A2, B2, B3);
                }
            }
        }
    }

    public double findMidianTwoFromThreeOne(Double A1, Double A2, Double A3, Double B) {
        if (B < A1)
            return (A1 + A2) / 2;
        else if (B > A3)
            return (A2 + A3) / 2;
        else
            return (A2 + B) / 2;
    }

    public double findMidianTwoFromTwoTwo(Double A1, Double A2, Double B1, Double B2) {
        double num1 = (A1 > B1) ? A1 : B1;
        double num2 = (A2 < B2) ? A2 : B2;
        return (num1 + num2) / 2;
    }
}