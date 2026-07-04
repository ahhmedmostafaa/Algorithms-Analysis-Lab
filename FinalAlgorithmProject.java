/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalalgorithmproject;

/**
 *
 * @author Ahmed mostafa
 */
import java.util.Arrays;
import java.util.Scanner;

public class FinalAlgorithmProject {

    // Merge Sort implementation
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // binarySearch function
    public static int binarySearch(int[] arr, int key) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Check if key is present at mid
        if (arr[mid] == key)
            return mid;

        // If key is greater, ignore left half
        if (arr[mid] < key)
            left = mid + 1;

        // If key is smaller, ignore right half
        else
            right = mid - 1;
    }

    // If the element is not present in the array
    return -1;
}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array a
        System.out.println("Enter elements of array a separated by spaces:");
        String[] aInput = scanner.nextLine().split("\\s+");
        int[] a = Arrays.stream(aInput).mapToInt(Integer::parseInt).toArray();

        // Input array b
        System.out.println("Enter elements of array b separated by spaces (must same size array a):");
        String[] bInput = scanner.nextLine().split("\\s+");
        int[] b = Arrays.stream(bInput).mapToInt(Integer::parseInt).toArray();

        // Sort arrays a and b
        mergeSort(a);
        quickSort(b, 0, b.length - 1);

        // Populate array c with smallest elements
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = Math.min(a[i], b[i]);
        }

        System.out.println("Array c: " + Arrays.toString(c));

        // Search key in array c
        System.out.println("Enter Search Key: ");
        int key = scanner.nextInt();
        int index = binarySearch(c, key);

    if (index != -1) {
        if (index < a.length) {
            System.out.println(key + " is found at index " + index + " in array a");
        } else if (index - a.length < b.length) {
            System.out.println(key + " is found at index " + (index - a.length) + " in array b");
        } else {
            System.out.println("Key found at an invalid index.");
        }
    } else {
        System.out.println("Not Found");
    }



        scanner.close();
        System.out.println("\nThe time complexity of Merge Sort is O(n log n)");
        System.out.println("The time complexity of Quick Sort is O(n^2)");
        System.out.println("The time complexity of the binarySearch function is O(log n)");
        System.out.println("The Big O complexity of the entire program is O(n^2)");
    }
}

