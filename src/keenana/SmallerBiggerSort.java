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
 * class to hold all of the sort methods. All methods are static
 * so therefore no instances of this class need to be made
 */
public class SmallerBiggerSort {
    /**
     * method that takes in an int and return the index of the first value in the list
     * @param list the list that needs to be sorted
     * @param startInclusive the first index of where the list needs to be sorted
     * @param endExclusive the ending index where the list needs to not be sorted
     * @return the index of the first value of the list after the sort
     * @param <T> generic for whatever is passed in.
     * @throws IllegalArgumentException if the list is null
     */
    public static <T extends Comparable<T>> int smallerBigger(List<T> list,
                                                              int startInclusive, int endExclusive){
        if (list == null) {
            throw new IllegalArgumentException();
        }
        if (startInclusive < 0 || endExclusive > list.size()){
            throw new IllegalArgumentException();
        }
        List<T> lessThan = new ArrayList<>();
        List<T> equals = new ArrayList<>();
        List<T> greaterThan = new ArrayList<>();
        List<T> before = new ArrayList<>();
        List<T> after = new ArrayList<>();
        for (int i = 0; i < startInclusive; i++){
            before.add(list.get(i));
        }
        for (int i = endExclusive; i < list.size(); i++){
            after.add(list.get(i));
        }
        T value = list.get(startInclusive);
        for (int i = startInclusive; i < endExclusive; i++){
            T data = list.get(i);
            if (data.compareTo(value) < 0){
                lessThan.add(data);
            } else if (data.compareTo(value) == 0){
                equals.add(data);
            } else {
                greaterThan.add(data);
            }
        }

        list.clear();
        list.addAll(before);
        list.addAll(lessThan);
        list.add(value);
        equals.remove(value);
        list.addAll(equals);
        list.addAll(greaterThan);
        list.addAll(after);

        return before.size() + lessThan.size();
    }

    /**
     * Recursive method that sorts a list
     * @param list the list to be sorted
     * @param startInclusive the initial start index
     * @param endExclusive the end index
     * @param <T> the generic implements comprable
     */
    public static <T extends Comparable<T>> void sort(List<T> list,
                                                      int startInclusive, int endExclusive){
        if (list == null) {
            throw new IllegalArgumentException();
        }
        if (startInclusive < 0 || endExclusive > list.size()){
            throw new IllegalArgumentException();
        }
        for (int i = startInclusive; i < endExclusive - 1; i++){
            int j = smallerBigger(list, i, endExclusive);
            while (j != i){
                j = smallerBigger(list, i, endExclusive);
            }
        }
    }

    /**
     * method that calls the recursive method is the public facing method
     * @param list the list to be sorted
     * @param <T> the generic that implements comparable
     */
    public static <T extends Comparable<T>> void sort(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        sort(list, 0, list.size());
    }
}