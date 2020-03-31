/* *****************************************************************************
 *  Name: Khushi Wadhwa
 *  Date: 3/27/2020
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.UF;

public class Percolation {
    private static int n;
    int[] objArr = new int[n * n + 2];
    UF uf = new UF(n * n);
    int count;
    int virtTop = 0;
    int virtBottom = n * n + 1;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }

        for (int i = 1; i <= n * n; i++) {
            objArr[i] = 0;
        }
    }

    // creates a 1D index for a 2D coordinate
    private int xyTo1D(int row, int col) {
        return ((row - 1) * n) + col;
    }

    // checks to make sure row and col are within bounds
    private void isValid(int i) {
        if (i > n || i <= 0) {
            throw new IllegalArgumentException("Number must be between 1 and N");
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        isValid(row);
        isValid(col);

        objArr[xyTo1D(row, col)] = 1;

        if (row == 1) {
            uf.union(virtTop, xyTo1D(row, col));
        }
        if (row == n) {
            uf.union(virtBottom, xyTo1D(row, col));
        }
        if (objArr[xyTo1D(row - 1, col)] == 1) {
            uf.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
        if (objArr[xyTo1D(row + 1, col)] == 1) {
            uf.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
        if (objArr[xyTo1D(row, col - 1)] == 1) {
            uf.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        }
        if (objArr[xyTo1D(row, col + 1)] == 1) {
            uf.union(xyTo1D(row, col), xyTo1D(row, col + 1));
        }

        count++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        isValid(row);
        isValid(col);

        if (objArr[xyTo1D(row, col)] == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        isValid(row);
        isValid(col);

        if (objArr[xyTo1D(row, col)] == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(virtTop, virtBottom);
    }

    // test client (optional)
    public static void main(String[] args) {
    }
}

