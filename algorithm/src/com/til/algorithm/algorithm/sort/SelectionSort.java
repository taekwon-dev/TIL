package com.til.algorithm.algorithm.sort;


/**
 *   https://st-lab.tistory.com/168
 *   선택 정렬 -> 현재 위치에 들어갈 데이터를 찾아 선택하는 알고리즘
 *
 *   데이터를 비교 하면서 찾기 때문에 비교 정렬이며,
 *   정렬의 대상이 되는 데이터 외 추가적인 공간을 필요로 하지 않기 때문에 제자리 정렬이기도 하다.
 *
 *   현재 위치와 최솟값 (오름차순기준) 인덱스에 있는 값을 스왑하는 과정에서 임시 변수가 필요하지만
 *   이는 충분히 무시할 만큼 적은 크기이기 때문에 제자리 정렬로 보는 것이다.
 *
 *   시간 복잡도 O(N^2)
 *
 *   현재 위치를 기준으로 나머지 배열에서 최솟값을 찾아야 한다.
 *   배열의 크기가 N인 경우,
 *
 *   0번   인덱스 -> 1 ~ N-1 인덱스 중 최솟값 -> N - 1번 비교
 *   1번   인덱스 -> 2 ~ N-1 인덱스 중 최솟값 -> N - 2번 비교
 *   N-2번 인덱스 -> N-2 ~ N-1 인덱스 중 최솟값 -> 1번 비교
 *
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 2, 1};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

    private static void selectionSort(int[] arr) {
        selectionSort(arr, 0);
    }

    /**
     * @param start
     *
     * Selection Sort 는 정렬 과정에서 { Sorted / Unsorted } 로 구분되는데,
     * 따라서 Unsorted 의 시작점을 기준으로 재귀 함수를 호출
     */
    private static void selectionSort(int[] arr, int start) {
        if (start < arr.length - 1) {
            // 배열의 마지막 인덱스를 포인터로 지정할 떄는 이미 해당 배열의 정렬이 완료된 상태이므로,
            // 배열 사이즈 - 1 보다 작은 인덱스일 때만 로직 통과

            // 시작 위치가 가장 작은 값일 수 있기 때문에,
            // 배열 내 최솟값 인덱스 값은 정렬되지 않은 구간의 시작 지점도 포함
            int min_index = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] < arr[min_index]) {
                    min_index = i;
                }
            }
            // 정렬되지 않은 구간 내에서 최솟값을 찾은 이후
            swap(arr, start, min_index);
            selectionSort(arr, start + 1);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
