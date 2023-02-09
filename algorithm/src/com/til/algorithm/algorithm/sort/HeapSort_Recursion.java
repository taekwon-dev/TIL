package com.til.algorithm.algorithm.sort;

/**
 *  시간 복잡도 : O(N log N)
 *
 *  0 - Indexed
 *  부모 노드 N
 *  왼쪽 자식 노드 N * 2 + 1
 *  오른쪽 자식 노드 N * 2 + 2
 */
public class HeapSort_Recursion {

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

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            // 이미 위 과정을 통해 Heapify를 수행 했으므로 루트 노드 기준으로만 Heapify 진행
            heapify(arr, 0, i - 1);
        }
    }

    /**
     *  자식 노드 인덱스를 통해 해당 노드의 부모 노드 인덱스 반환
     */
    private static int getParent(int child) {
        return (child - 1) / 2;
    }

    private static void heapify(int[] arr, int parentIdx, int lastIdx) {

        /**
         *  현재 트리에서 부모 노드의 자식 노드 인덱스를 각각 구한다.
         *  이 때 부모 인덱스를 가장 큰 값을 가지고 있다고 가정한다.
         */
        int parent = parentIdx;
        int left = parentIdx * 2 + 1;
        int right = parentIdx * 2 + 2;

        /**
         *  자식 노드 인덱스가 배열의 마지막 원소 인덱스를 넘어가지 않으면서
         *  현재 가장 큰 인덱스보다(=부모) 왼쪽 자식 노드의 값이 더 큰 경우
         */
        if (left < lastIdx && arr[parent] < arr[left]) {
            parent = left;
        }

        /**
         *  자식 노드 인덱스가 배열의 마지막 원소 인덱스를 넘어가지 않으면서
         *  현재 가장 큰 인덱스보다(=부모) 오른쪽 자식 노드의 값이 더 큰 경우
         */
        if (right < lastIdx && arr[parent] < arr[right]) {
            parent = right;
        }

        /**
         *  `parent` 과 `parentIdx` 가 서로 같지 않다는 것은
         *  위 과정에서 부모 노드보다 큰 자식 노드가 있다는 것을 의미한다.
         *  이 경우, 해당 자식 노드와 부모 노드의 값을 스왑하고,
         *  교환 이후 자식 노드를 부모 노드로 삼은 서브 트리를 검사하도록 재귀 호출 한다.
         */
        if (parentIdx != parent) {
            swap(arr, parent, parentIdx);
            heapify(arr, parent, lastIdx);
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}