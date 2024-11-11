/*
 * Course: CSC 1120 121
 * Term: spring 2024
 * Assignment: lab 12
 * Name: Andrew Keenan
 * Created: 4-10-24
 */
package keenana;

import java.util.ArrayList;
import java.util.List;

/**
 * driver class for benchmarking times
 */
public class Driver {
    public static void main(String[] args) {
        final Integer[] inOrder = {0, 1, 2, 3, 4, 5, 6, 7};
        final Integer[] inverse = {7, 6, 5, 4, 3, 2, 1};
        final Integer[] random = {8, 3, 8, 5, 12, 1, 8, 18, 13};
        List<Integer> iO = new ArrayList<>(List.of(inOrder));
        List<Integer> iN = new ArrayList<>(List.of(inverse));
        List<Integer> ran = new ArrayList<>(List.of(random));
        long s;
        long e;
        s = System.nanoTime();
        SmallerBiggerSort.sort(iO);
        e = System.nanoTime();
        System.out.println("In order list");
        System.out.println(e - s);
        s = System.nanoTime();
        SmallerBiggerSort.sort(iN);
        e = System.nanoTime();
        System.out.println("Inverse List");
        System.out.println(e - s);
        s = System.nanoTime();
        SmallerBiggerSort.sort(ran);
        e = System.nanoTime();
        System.out.println("Random List");
        System.out.println(e - s);
    }
}
