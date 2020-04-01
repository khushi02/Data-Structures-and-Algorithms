/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    int n;
    int t;
    Percolation perc = new Percolation(n);
    double stats[] = new double[t];

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException(
                    "Grid size and number of trials must be greater than 0.");
        }

        for (int i = 0; i < trials; i++) {
            while (!perc.percolates()) {
                int row = StdRandom.uniform(1, n);
                int col = StdRandom.uniform(1, n);
                if (perc.isFull(row, col)) {
                    perc.open(row, col);
                }
            }
            stats[i] = perc.count;
        }
        StdOut.println("Mean: " + mean());
        StdOut.println("Standard Deviation: " + stddev());
        StdOut.println("95% confidence interval: [" + confidenceLo() + ", " + confidenceHi() + "]");
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(stats);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(stats);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (stddev() / t);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (stddev() / t);
    }

    // test client (see below)
    public static void main(String[] args, int n, int t) {
    }
}
