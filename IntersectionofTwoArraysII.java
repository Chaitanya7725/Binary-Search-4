import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArraysII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }))); // [2,2]
        System.out.println(Arrays.toString(intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }))); // [4,9]
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[] {};
        int p1 = 0;
        int p2 = 0;
        if (nums1.length > nums2.length)
            intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> list = new ArrayList<>();
        while (p1 < m && p2 < n) {
            if (nums1[p1] > nums2[p2]) {
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}