package main.java;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0;
        while (i < v1.length || i < v2.length) {
            if (i < v1.length && i < v2.length) {
                int a = Integer.parseInt(v1[i]);
                int b = Integer.parseInt(v2[i]);
                if (a > b) {
                    return 1;
                } else if (a < b) {
                    return -1;
                }
            } else if (i < v1.length && Integer.parseInt(v1[i]) > 0) {  // i == v2.length now
                return 1;
            } else if (i < v2.length && Integer.parseInt(v2[i]) > 0) {
                return -1;
            }

            i++;
        }

        return 0;
    }

    public static void main(String[] args) {
        String a = "1", b = "0";
        System.out.print(compareVersion(a, b));
    }
}
