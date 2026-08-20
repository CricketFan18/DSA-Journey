## **Problem Statement**

There is a row of $n$ houses, where each house can be painted in one of three colors: **red**, **blue**, or **green**. The cost of painting each house with a certain color is different. You have to paint all the houses such that **no two adjacent houses have the same color**.

The cost of painting each house with a certain color is represented by an $n \times 3$ cost matrix `costs`:

* `costs[i][0]` is the cost of painting house `i` red.
* `costs[i][1]` is the cost of painting house `i` blue.
* `costs[i][2]` is the cost of painting house `i` green.

Return *the minimum cost to paint all houses*.

---

## **Examples**

### **Example 1:**

```text
Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation:
- Paint house 0 blue  (cost = 2)
- Paint house 1 green (cost = 5)
- Paint house 2 blue  (cost = 3)
Total minimum cost = 2 + 5 + 3 = 10.

```

### **Example 2:**

```text
Input: costs = [[7,6,2]]
Output: 2
Explanation:
- Paint house 0 green (cost = 2)
Total minimum cost = 2.

```

---

## **Constraints**

* `costs.length == n`
* `costs[i].length == 3`
* $1 \le n \le 100$
* $1 \le \text{costs}[i][j] \le 20$