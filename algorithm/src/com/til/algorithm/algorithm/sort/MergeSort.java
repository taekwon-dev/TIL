package com.til.algorithm.algorithm.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 7, 8, 6, 5, 8, 9, 10};
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }

    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);

            // 나누고 나서 병합
            merge(arr, tmp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        // Part1에 남은 경우
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
        /**
         *   Part1 = 2, 3, 4, 6
         *   Part2 = 1, 5, 7, 8
         *
         *   위와 같이 두 개의 파티션으로 나뉘었을 때 Part2의 7, 8의 경우 while loop 내에서 처리되지 않지만,
         *   별도로 처리할 필요가 없는데 결과적으로 7, 8의 경우 우리가 기대하는 위치에 있기 때문이다.
         *
         *   뒤에 있는 파티션에 있는 값이 남은 경우 별도로 해당 인덱스에 오버라이트 하지 않아도 원래 예상된 값이 있고,
         *   앞에 있는 파티션에 있는 값이 남은 경우는 남은 값들의 정렬 후 위치가 뒤 쪽에 있어야 하기 때문에 별도로 남은 것에 대해서 처리를 해야 한다.
         */
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
