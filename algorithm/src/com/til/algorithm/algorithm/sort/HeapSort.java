package com.til.algorithm.algorithm.sort;

/**
 * https://st-lab.tistory.com/205 : Heap 자료구조 ... Priority Queue
 * https://st-lab.tistory.com/225 : Heap Sort
 * <p>
 * 시간 복잡도 계산 이해해보기.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 10, 35, 23, 19, 47, 60, 35, 80, 44};
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

    private static void heapSort(int[] arr) {

        if (arr.length < 2) {
            return;
        }
        int parent = getParent(arr.length - 1);

        for (int i = parent; i >= 0; i--) {
            heapify(arr, i, arr.length - 1);
        }

        // 힙 정렬
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            // 최대 힙 구성 후 가장 큰 값을 배열의 오른쪽부터 채운다.
            // 따라서 배열의 오른쪽부터 순차적으로 unsorted / sorted 형태로 정렬이 진행된다.
            // 재귀호출 과정에서 마지막 인덱스 - 1 처리하면서 정렬을 순차적으로 진행
            heapify(arr, 0, i - 1);
        }
    }

    private static int getParent(int child) {
        return (child - 1) / 2;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void heapify(int[] arr, int parentIdx, int lastIdx) {

        int parent = parentIdx;
        int left = parentIdx * 2 + 1;
        int right = parentIdx * 2 + 2;

        // 범위 내 위치하고, 왼쪽 자식 값이 부모 값보다 큰 경우
        if (left < lastIdx && arr[parent] < arr[left]) {
            parent = left;
        }

        // 범위 내 위치하고, 오른쪽 자식 값이 부모 값보다 큰 경우
        // 만약 왼쪽 자식 노드와 부모 노드가 이미 바뀐 경우 -> 왼쪽 / 오른쪽 자식 노드 중 큰 값이 부모 노드 자리로 올라갈 수 있도록
        if (right < lastIdx && arr[parent] < arr[right]) {
            parent = right;
        }

        // 부모 노드 값이 자식 노드 중 하나로 바뀐 경우
        if (parentIdx != parent) {
            // 부모 노드와 자식 노드 스왑
            swap(arr, parent, parentIdx);
            // 부모 노드와 위치를 바꾼 자식 노드를 부모 노드로 해서 다시 전체 범위에서 최대 힙 구성 적용
            // 위치가 바뀌었을 때 힙 구조가 불완전 정렬이므로 최대 힙 구성이 깨질 수 있기 때문에 바뀐 자식 노드를 기준으로 다시 진행
            heapify(arr, parent, lastIdx);
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
