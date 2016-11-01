package main.java;

public class LC396RotateFunction {
    // f(0)=0A+1B+2C+3D
    // f(1)=1A+2B+3C+0D
    // f(2)=2A+3B+0C+1D
    // f(3)=3A+0B+1C+2D
    // f(1) = f(0) + (A+B+C+D) - 4D
    // f(2) = f(1) + (A+B+C+D) - 4C
    // f(3) = f(2) + (A+B+C+D) - 4B
    // 4 is the length

    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int sum = 0, candidate = 0, length = A.length;
        for (int i = 0; i < length; i++) {
            sum += A[i];
            candidate += i * A[i];
        }

        int best = candidate;
        for (int i = 1; i < length; i++) {
            candidate = candidate + sum - length*A[length-i];
            best = Math.max(best, candidate);
        }

        return best;
    }
}
