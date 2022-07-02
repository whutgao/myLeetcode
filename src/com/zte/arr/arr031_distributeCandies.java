package com.zte.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class arr031_distributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int c:candyType
             ) {
            // 优化，判断到达n/2后，直接return
//            set.add(c);
            if (set.add(c)&&set.size()>=candyType.length/2){
                return candyType.length/2;
            }
        }
        return Math.min(candyType.length/2,set.size());

//        long count = Arrays.stream(candyType).distinct().count();
//        return Math.min((int)count,candyType.length/2);

    }

    public static void main(String[] args) {
        // Creating an integer array
        int arr[] = { 1, 2, 3, 4, 5 };

        // --------- Using Arrays.stream() ---------

        // to convert int array into Stream
        IntStream intStream = Arrays.stream(arr);

        // Displaying elements in Stream
        intStream.forEach(str -> System.out.print(str + " "));

        // --------- Using Stream.of() ---------

        // to convert int array into Stream
        Stream<int[]> stream = Stream.of(arr);

        // Displaying elements in Stream
        stream.forEach(str -> System.out.print(str + " "));
    }
}
