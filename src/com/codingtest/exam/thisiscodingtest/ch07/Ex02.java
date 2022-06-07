package com.codingtest.exam.thisiscodingtest.ch07;

// 이진 탐색

public class Ex02 {
    static int recursiveBinarySearch(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid;
        }
        // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else if (array[mid] > target) {
            return recursiveBinarySearch(array, target, start, mid - 1);
        }
        // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else {
            return recursiveBinarySearch(array, target, mid + 1, end);
        }
    }

    static int repeatBinarySearch(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (array[mid] == target) {
                return mid;
            }
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (array[mid] > target) {
                end = mid - 1;
            }
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.println(recursiveBinarySearch(array, 9, 0, array.length - 1));
        System.out.println(repeatBinarySearch(array, 5, 0, array.length - 1));
    }
}
