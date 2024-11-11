/*
 * Course: CSC 1120 121
 * Term: spring 2024
 * Assignment: lab 12
 * Name: Andrew Keenan
 * Created: 4-10-24
 */

package test;

import keenana.SmallerBiggerSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * test class for the SmallerBiggerSort class
 */
public class SmallerBiggerSortTests {
    private final Integer[] list1 = {7, 4, 8, 9, 1};
    private final Integer[] list2 = {0, 1, 2, 3, 4};
    private final Integer[] list3 = {4, 5, 3, 2, 1};
    private final Integer[] list4 = {8, 3, 8, 5, 12, 1, 8, 18, 13};

    /**
     * test for the smallerBigger method
     */
    @Test
    public void smallerBigger(){
        List<Integer> nums1 = new ArrayList<>(List.of(list1));
        List<Integer> nums2 = new ArrayList<>(List.of(list2));
        List<Integer> nums3 = new ArrayList<>(List.of(list3));
        List<Integer> nums4 = new ArrayList<>(List.of(list4));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                SmallerBiggerSort.smallerBigger(null, 0, 1));
        Assertions.assertEquals(2, SmallerBiggerSort.smallerBigger(nums1, 0, nums1.size()));
        Assertions.assertEquals(0, SmallerBiggerSort.smallerBigger(nums2, 0, nums2.size()));
        Assertions.assertEquals(3, SmallerBiggerSort.smallerBigger(nums3, 0, nums3.size()));
        Assertions.assertEquals(3, SmallerBiggerSort.smallerBigger(nums4, 0, nums4.size()));
    }

    /**
     * tests the recursive method for sort
     */
    @Test
    public void sortInternal(){
        List<Integer> nums1 = new ArrayList<>(List.of(list1));
        List<Integer> nums2 = new ArrayList<>(List.of(list2));
        List<Integer> nums3 = new ArrayList<>(List.of(list3));
        List<Integer> nums4 = new ArrayList<>(List.of(list4));
        String sort1 = "[7, 4, 1, 8, 9]";
        String sort2 = "[0, 1, 2, 3, 4]";
        String sort3 = "[4, 5, 1, 2, 3]";
        String sort4 = "[8, 3, 1, 5, 8, 8, 12, 13, 18]";
        int start = 2;
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                SmallerBiggerSort.sort(null, 0, 1));
        SmallerBiggerSort.sort(nums1, start, nums1.size());
        Assertions.assertEquals(sort1, nums1.toString());
        SmallerBiggerSort.sort(nums2, start, nums2.size());
        Assertions.assertEquals(sort2, nums2.toString());
        SmallerBiggerSort.sort(nums3, start, nums3.size());
        Assertions.assertEquals(sort3, nums3.toString());
        SmallerBiggerSort.sort(nums4, start, nums4.size());
        Assertions.assertEquals(sort4, nums4.toString());
    }

    /**
     * tests the whole sort method
     */
    @Test
    public void sortWhole(){
        List<Integer> nums1 = new ArrayList<>(List.of(list1));
        List<Integer> nums2 = new ArrayList<>(List.of(list2));
        List<Integer> nums3 = new ArrayList<>(List.of(list3));
        List<Integer> nums4 = new ArrayList<>(List.of(list4));
        String sort1 = "[1, 4, 7, 8, 9]";
        String sort2 = "[0, 1, 2, 3, 4]";
        String sort3 = "[1, 2, 3, 4, 5]";
        String sort4 = "[1, 3, 5, 8, 8, 8, 12, 13, 18]";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                SmallerBiggerSort.sort(null));
        SmallerBiggerSort.sort(nums1);
        Assertions.assertEquals(sort1, nums1.toString());
        SmallerBiggerSort.sort(nums2);
        Assertions.assertEquals(sort2, nums2.toString());
        SmallerBiggerSort.sort(nums3);
        Assertions.assertEquals(sort3, nums3.toString());
        SmallerBiggerSort.sort(nums4);
        Assertions.assertEquals(sort4, nums4.toString());
    }

}
