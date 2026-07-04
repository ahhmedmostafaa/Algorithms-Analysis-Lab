/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalalgorithmprojectgui;

/**
 *
 * @author Ahmed mostafa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class FinalAlgorithmProjectGUI extends JFrame {

    private final JTextField arrayATextField;
    private final JTextField arrayBTextField;
    private final JTextField searchKeyTextField;
    private final JTextArea resultTextArea;

    public FinalAlgorithmProjectGUI() {
        setTitle("Final Algorithm Project");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Array a:"));
        arrayATextField = new JTextField();
        inputPanel.add(arrayATextField);

        inputPanel.add(new JLabel("Array b:"));
        arrayBTextField = new JTextField();
        inputPanel.add(arrayBTextField);

        inputPanel.add(new JLabel("Search Key:"));
        searchKeyTextField = new JTextField();
        inputPanel.add(searchKeyTextField);

        add(inputPanel, BorderLayout.NORTH);

        JButton searchButton = new JButton("Search");
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);
        add(resultScrollPane, BorderLayout.CENTER);

        JPanel arrayCPanel = new JPanel(new BorderLayout());
        JTextArea arrayCTextArea = new JTextArea();
        arrayCTextArea.setEditable(false);
        arrayCPanel.add(new JLabel("Array c:"), BorderLayout.NORTH);
        arrayCPanel.add(new JScrollPane(arrayCTextArea), BorderLayout.CENTER);
        add(arrayCPanel, BorderLayout.SOUTH);

        add(searchButton, BorderLayout.SOUTH);

        searchButton.addActionListener((ActionEvent e) -> {
            searchButtonClicked();
        });
    }

    private void searchButtonClicked() {
        String arrayAInput = arrayATextField.getText();
        String arrayBInput = arrayBTextField.getText();
        String searchKeyInput = searchKeyTextField.getText();

        int[] a = Arrays.stream(arrayAInput.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(arrayBInput.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(searchKeyInput);

        int[] c = new int[a.length];
        mergeSort(a);
        quickSort(b, 0, b.length - 1);
        for (int i = 0; i < a.length; i++) {
            c[i] = Math.min(a[i], b[i]);
        }

        StringBuilder cStringBuilder = new StringBuilder();
        cStringBuilder.append("[ ");
        for (int i = 0; i < c.length; i++) {
            cStringBuilder.append(c[i]);
            if (i < c.length - 1) {
                cStringBuilder.append(", ");
            }
        }
        cStringBuilder.append(" ]");
        resultTextArea.setText("");
        resultTextArea.append("Array c: " + cStringBuilder.toString() + "\n");

        int index = binarySearch(c, key);

        if (index != -1) {
            if (index < a.length) {
                resultTextArea.append(key + " is found at index " + index + " in array a\n");
            } else {
                resultTextArea.append(key + " is found at index " + (index - a.length) + " in array b\n");
            }
        } else {
            resultTextArea.append("Not Found\n");
        }
        resultTextArea.append("\nThe time complexity of Merge Sort is O(n log n)");
        resultTextArea.append("\nThe time complexity of Quick Sort is O(n^2)");
        resultTextArea.append("\nThe time complexity of the binarySearch function is O(log n)");
        resultTextArea.append("\nThe Big O complexity of the entire program is O(n^2)");
    }
    

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

    // Search function
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
        SwingUtilities.invokeLater(() -> {
            FinalAlgorithmProjectGUI gui = new FinalAlgorithmProjectGUI();
            gui.setVisible(true);
        });
    }
}
