/* *****************************************************************************
 *  Name: Khushi Wadhwa
 *  Date: 3/27/2020
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.UF;

public class Percolation {
    int n;
    int[] objArr = new int[n * n];
    UF uf = new UF(n);

    private int xyTo1D(int row, int col) {
        return ((row - 1) * n) + col;
    }

    private void isValid(int i) {
        if (i > n || i <= 0) {
            throw new IllegalArgumentException("Number must be between 1 and N");
        }
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }
        //int[] rowArr = new int[n];
        //int[] colArr = new int[n];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                objArr[xyTo1D(i, j)] = 0;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        isValid(row);
        isValid(col);

        objArr[xyTo1D(row, col)] = 1;

        if (objArr[xyTo1D(row - 1, col)] == 1) {
            uf.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
        else if (objArr[xyTo1D(row + 1, col)] == 1) {
            uf.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
        else if (objArr[xyTo1D(row, col - 1)] == 1) {
            uf.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        }
        else if (objArr[xyTo1D(row, col + 1)] == 1) {
            uf.union(xyTo1D(row, col), xyTo1D(row, col + 1));
        }
    }
/*
    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    }


    // returns the number of open sites
    public int numberOfOpenSites() {
    }

    // does the system percolate?
    public boolean percolates() {
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = StdIn.readInt();

        Percolation perc = new Percolation(n);

        while (!StdIn.isEmpty()) {
            int row = StdIn.readInt();
            int col = StdIn.readInt();
        }
    }
     */
}
