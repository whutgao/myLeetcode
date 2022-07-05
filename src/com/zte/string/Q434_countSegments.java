package com.zte.string;

import java.util.Arrays;

public class Q434_countSegments {
    public static void main(String[] args) {
        int i = countSegments("                ");
        System.out.println(i);

    }

    private static int countSegments(String s) {

        if (s.trim().length()==0){
            return 0;
        }

        String[] arr = s.trim().split("\\s+");
        System.out.println(Arrays.toString(arr));
        return arr.length;
    }
}
