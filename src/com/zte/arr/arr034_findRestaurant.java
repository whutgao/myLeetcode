package com.zte.arr;

import java.util.*;

/**
 * 两个列表的最小索引总和
 * <p>
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，
 * 每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。
 * 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 */
public class arr034_findRestaurant {

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "Burger King", "Hungry Hunter Steakhouse", "Shogun"};

        String[] restaurant = findRestaurant1(list1, list2);
        System.out.println(Arrays.toString(restaurant));
    }

    private static String[] findRestaurant(String[] list1, String[] list2) {

        // 字符串比较最好用equals() ，不用==
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    map.put(list1[i], i + j);
                }
            }
        }

        List<String> res = new ArrayList<>();
        Optional<Integer> min = map.values().stream().distinct().min(Integer::compareTo);
        if (min.isPresent()) {
            for (String s : map.keySet()) {
                if (map.get(s).equals(min.get())) {
                    res.add(s);
                }
            }
        }

        return res.toArray(new String[res.size()]);


//        HashMap < Integer, List < String >> map = new HashMap < > ();
//        for (int i = 0; i < list1.length; i++) {
//            for (int j = 0; j < list2.length; j++) {
//                if (list1[i].equals(list2[j])) {
//                    if (!map.containsKey(i + j)) {
//                        map.put(i + j, new ArrayList < String > ());
//                    }
//                    map.get(i + j).add(list1[i]);
//                }
//            }
//        }
//        int min_index_sum = Integer.MAX_VALUE;
//        for (int key: map.keySet()) {
//            min_index_sum = Math.min(min_index_sum, key);
//        }
//        String[] res = new String[map.get(min_index_sum).size()];
//        return map.get(min_index_sum).toArray(res);
        // 注释方法的时间复杂度：O(l1*l2*x) x是字符串的平均长度 空间复杂度：O(l1*l2*x)

    }


    public static String[] findRestaurant1(String[] list1, String[] list2) {
        // 因为sum和的范围是一定的，从0开始遍历到sum最大值，res不为空的情况就是sum最小的情况
        List<String> res = new ArrayList<>();
        for (int sum = 0; sum < list1.length + list2.length - 1; sum++) {
            for (int i = 0; i <= sum; i++) {
                if (i < list1.length && sum - i < list2.length && list1[i].equals(list2[sum - i])) {
                    res.add(list1[i]);
                }
            }
            if (res.size() > 0) {
                break;
            }
        }
        return res.toArray(new String[3]);
//        这里的用new String[0]只是为了指定函数的形参数，
//        最终返回的String[]的长度是由你的list存储内容的长度决定了。
//        长度小于size，就返回size；大于size就补充0
//        public <T> T[] toArray(T[] a) {
//            int size = size();
//            if (a.length < size)
//                return Arrays.copyOf(this.a, size,
//                        (Class<? extends T[]>) a.getClass());
//            System.arraycopy(this.a, 0, a, 0, size);
//            if (a.length > size)
//                a[size] = null;
//            return a;
//        }
    }

}
