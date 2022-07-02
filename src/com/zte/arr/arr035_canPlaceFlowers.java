package com.zte.arr;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，
 * 花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，
 * 其中 0 表示没种植花，1 表示种植了花。另有一个数n ，
 * 能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
 */
public class arr035_canPlaceFlowers {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0};
        int n = 1;
        canPlaceFlowers(arr, n);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) {
            return true;
        }

        if (flowerbed.length == Arrays.stream(flowerbed).boxed().filter(integer -> integer.equals(0)).count()) {
            return (flowerbed.length + 1) / 2 >= n;
        }


        // 这种方法忽略了两边都是0的情况
        int count = 0;
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                indexList.add(i);
            }
        } // 不应该用1，应该用0 忽略了全是0的情况和两边都是0的情况

        for (int i = 1; i < indexList.size(); i++) {
            count = count + ((indexList.get(i) - indexList.get(i - 1)) - 2) / 2;
        }

        if (indexList.size() > 0) {
            if (flowerbed[0] == 0) {
                count += ((indexList.get(0))) / 2;
            }
            if (flowerbed[flowerbed.length - 1] == 0) {
                count += ((flowerbed.length - 1 - indexList.get(indexList.size() - 1))) / 2;
            }
        }
        return count >= n;
    }


    private static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        // 记录左边的点，找到等于1的后计算数量再更新，最后根据prev和m来判断prev的右侧有没有
        for (int i = 0; i < m; i++) {
            if (flowerbed[i]==1){
                if (prev<0){
                    count+=(i-0-1+1)/2;
                }else {
                    count+=((i-prev-1-2)+1)/2;
                }
                prev=i;
            }
        }

        if (prev<0){
            count+=(m+1)/2;
        }else {
            count+= ((m-prev-1-1)+1)/2;
        }

        return count >= n;
    }


}
