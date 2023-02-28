package com.til.algorithm.algorithm.binary_search;

public class BinarySearch {

    private static int[] arr = {1, 2, 5, 7, 9, 11, 34, 45, 66, 78, 97, 100};

    public static void main(String[] args) {
        System.out.println(binarySearch1(11, 0, arr.length - 1));  // 5 (Index)
        System.out.println(binarySearch1(101, 0, arr.length - 1)); // -1

        System.out.println(binarySearch2(11, 0, arr.length - 1));  // 5 (Index)
        System.out.println(binarySearch2(101, 0, arr.length - 1)); // -1
    }

    private static int binarySearch1(int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // 배열 내 탐색 대상이 없는 경우 `-1` 반환
        return -1;
    }

    private static int binarySearch2(int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch2(target, low, mid - 1);
        } else {
            return binarySearch2(target, mid + 1, high);
        }
    }
}
