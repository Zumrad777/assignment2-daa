

# Assignment 2: Algorithmic Analysis and Peer Code Review
### Student A – Shell Sort Implementation

## Project Overview
This project implements the **Shell Sort algorithm** using three gap sequences:
- Shell’s sequence
- Knuth’s sequence
- Sedgewick’s sequence

The goal is to analyze algorithmic complexity and measure performance on different input sizes (n = 100, 1,000, 10,000, 100,000).

---

## How to Run

### 1️ Run Unit Tests
```bash
mvn test
````

### 2️⃣ Run Benchmark

```bash
mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner"
```

This will print execution time, comparisons, and swaps for each input size and gap sequence.

---

## Performance Summary

| Gap Sequence | n=100    | n=1,000  | n=10,000 | n=100,000 |
| ------------ | -------- | -------- | -------- | --------- |
| Shell        | 0.00012s | 0.0010s  | 0.0103s  | 0.108s    |
| Knuth        | 0.00010s | 0.00083s | 0.0089s  | 0.093s    |
| Sedgewick    | 0.00009s | 0.00075s | 0.0082s  | 0.086s    |

---

## Complexity

* Best Case: Θ(n log n)
* Average Case: O(n (log n)²)
* Worst Case: O(n²)
* Space: O(1)

---

## Author

**Zumrad Sherbadalova**
Student A — Shell Sort
