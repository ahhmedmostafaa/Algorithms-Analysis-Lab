# Algorithms Analysis Lab — Sort & Search Complexity Study

A Java implementation and complexity analysis of classic sorting and searching algorithms, combining two independently-sorted arrays and performing a search across the merged result. Available as both a console application and a GUI version.

## What it does
1. Takes two input arrays, **a** and **b**
2. Sorts **a** using **Merge Sort** — O(n log n)
3. Sorts **b** using **Quick Sort** — O(n²) worst case
4. Builds array **c**, where `c[i] = min(a[i], b[i])`
5. Performs a **Binary Search** — O(log n) — on **c** for a target key, and reports which original array the result came from

## Complexity Analysis

| Operation | Algorithm | Time Complexity |
|---|---|---|
| Sort array a | Merge Sort | O(n log n) |
| Sort array b | Quick Sort | O(n²) worst case |
| Search in c | Binary Search | O(log n) |
| **Overall program** | — | **O(n²)** (dominated by Quick Sort's worst case) |

## Project Structure
```
FinalAlgorithmProject/      # Console version (input via terminal)
FinalAlgorithmProjectGUI/   # GUI version (Java Swing)
```

## Tech Stack
- Java
- Maven
- Java Swing (GUI version)

## How to Run

**Console version:**
```bash
cd FinalAlgorithmProject
mvn compile
mvn exec:java -Dexec.mainClass="com.mycompany.finalalgorithmproject.FinalAlgorithmProject"
```

**GUI version:**
```bash
cd FinalAlgorithmProjectGUI
mvn compile
mvn exec:java -Dexec.mainClass="com.mycompany.finalalgorithmprojectgui.FinalAlgorithmProjectGUI"
```
