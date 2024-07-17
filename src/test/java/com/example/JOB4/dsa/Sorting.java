package com.example.JOB4.dsa;

import java.util.Arrays;

public class Sorting {
	public static void main(final String[] args) {
		insertionSort();
//		bubbleSort();
//		quickSort();
	}

	private static void quickSort() {
		final int arr[] = { 4, 3, 1, 6, 5, 8, 2 };
		final int low = 0, high = arr.length - 1;
		quickSortLogic(arr, low, high);
		System.out.println(Arrays.toString(arr));

	}

	private static void quickSortLogic(final int[] arr, final int low, final int high) {
		System.out.println("quickSortLogic : " + high);
		if (low < high) {
			final int pi = quickSortPartitionLogic(arr, low, high);
			quickSortLogic(arr, low, pi - 1);
			quickSortLogic(arr, pi + 1, high);

		}

	}

	private static int quickSortPartitionLogic(final int[] arr, final int low, final int high) {
		System.out.println("quickSortPartitionLogic : " + arr[high]);
		final int pivit = arr[high];
		int i = low - 1;
		int j = low;
		for (j = low; j < high; j++) {
			if (arr[j] < pivit) {
				i++;
				final int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		final int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;

	}

	private static void bubbleSort() {
		final int arr[] = { 4, 3, 1, 6, 5, 8, 2 };

		for (int i = 0; i < arr.length - 1; i++) {
			int minIndx = i;
			int j = i + 1;
			for (j = j; j < arr.length; j++) {
				if (arr[j] < arr[minIndx]) {
					minIndx = j;
				}
			}
			final int temp = arr[minIndx];
			arr[minIndx] = arr[i];
			arr[i] = temp;

		}

		System.out.println("Bubble Sort : " + Arrays.toString(arr));

	}

	private static void insertionSort() {

		final int arr[] = { 4, 3, 1, 6, 5, 8, 2 };

		for (int i = 0; i < arr.length; i++) {

			final int min = arr[i];
			int j = i - 1;
			System.out.println(" i & j : " + i + " **** " + j);
			while (j >= 0 && arr[j] > min) {
				System.out.println(" inside while i & j :" + i + " **** " + j);
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = min;
		}
		System.out.println(Arrays.toString(arr));
	}

}
