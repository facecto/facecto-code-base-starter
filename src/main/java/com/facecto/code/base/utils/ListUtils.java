package com.facecto.code.base.utils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jon So
 * @author page https://cto.pub
 * @date 2021/6/25
 */
public class ListUtils {
    public static boolean hasEqual(List<Integer> list1, List<Integer> list2){
        List<Integer> collect1 = list1.stream().sorted(Comparator.comparing(a -> a)).collect(Collectors.toList());
        List<Integer> collect2 = list2.stream().sorted(Comparator.comparing(a -> a)).collect(Collectors.toList());
        return collect1.equals(collect2);
    }
}
