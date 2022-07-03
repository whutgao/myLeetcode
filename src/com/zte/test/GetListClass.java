package com.zte.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 时遇
 */
public class GetListClass {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        List<Integer> integers = new ArrayList<Integer>(){};

        integers.add(1);
        integers.add(2);
        Type calzz = integers.getClass().getGenericSuperclass();
        ParameterizedType calzz1 = (ParameterizedType) calzz;
        Type actualTypeArgument = calzz1.getActualTypeArguments()[0];
        System.out.println(actualTypeArgument);
        System.out.println(integers);

    }



    public static String getActualType(Object o,int index) {
        Type clazz = o.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)clazz;
        return pt.getActualTypeArguments()[index].toString();
    }
//    private static Map<String,List<>> convertT(List<> strs){
//
//        strs.getClass()
//        return null;
//    }



}
