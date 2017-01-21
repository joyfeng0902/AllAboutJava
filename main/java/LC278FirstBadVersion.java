package main.java;

class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}
public class LC278FirstBadVersion extends VersionControl  {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (isBadVersion(low)) {
            return low;
        }

        if (isBadVersion(high)) {
            return high;
        }

        return low;
    }
}
