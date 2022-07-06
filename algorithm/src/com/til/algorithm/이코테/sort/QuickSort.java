package com.til.algorithm.이코테.sort;

/* https://www.youtube.com/watch?v=EuJSDghD4z8 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return; // 원소가 한 개인 경우 종료
        int pivot = start;
        int left = start + 1; // pivot 을 기준으로 왼쪽 포인터 지정
        int right = end;

        while (left <= right) {
            // pivot 보다 큰 수 찾을 때 까지 반복 (큰 수에 포인터 지정)
            while (left <= end && arr[left] <= arr[pivot]) left++;

            // pivot 보다 작은 수 찾을 때 까지 반복 (작은 수에 포인터 지정)
            while (right > start && arr[right] >= arr[pivot]) right--;

            if (left > right) {
                int tmp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = tmp;
            } else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        quickSort(arr, start, right - 1); // right -> 분할된 배열에서 pivot 역할
        quickSort(arr, right + 1, end);  // pivot 기준으로 +1 ~ end 범위
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
