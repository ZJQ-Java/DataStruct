package com.qiu.DataStructTest;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrDuplicationFind {

    public static boolean duplicate(int[] arr, int length, int[] duplication) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    duplication[0] = arr[i];
                    return true;
                }
                swap(arr, i, arr[i]);
            }

        }
        return false;
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean duplicate(int[] arr, int[] duplication) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        HashSet<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toCollection(HashSet::new));
        if (set.size() != arr.length) {
            for (int value : arr) {
                if (set.contains(value)) {
                    set.remove(value);
                } else {
                    duplication[0] = value;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 0};
        int[] duplication = new int[10];
        boolean arrDuplication = duplicate(arr,  duplication);
        System.out.println(arrDuplication +" "+ duplication[0]);
    }


}
