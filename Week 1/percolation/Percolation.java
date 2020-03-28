/* *****************************************************************************
 *  Name: Khushi Wadhwa
 *  Date: 3/27/2020
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class Percolation {

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }
        else {
            int[] rowArr = new int[n];
            int[] colArr = new int[n];
        }
    }

    /*
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    }

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
*/
    // test client (optional)
    public static void main(String[] args) {
        int n = StdIn.readInt();

        Percolation perc = new Percolation(n);

        while (!StdIn.isEmpty()) {
            int row = StdIn.readInt();
            int col = StdIn.readInt();

            if (row > n || row <= 0) {
                throw new IllegalArgumentException("Row number must be between 0 and N");
            }
            else if (col > n || col <= 0) {
                throw new IllegalArgumentException("Column number must be between 0 and N");
            }
        }
    }
}
