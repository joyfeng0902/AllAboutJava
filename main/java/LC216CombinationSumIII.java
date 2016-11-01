import java.util.LinkedList;
import java.util.List;

public class LC216CombinationSumIII {
    // using depth first search
    // arr is [1,...,9], already sorted and each element is unique
    // 时间 O(9!) 空间 O(9) 递归栈空间
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int k, int n) {
        result = new LinkedList<List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        dfs(n, k, 1, tmp);

        return result;
    }

    void dfs(int n, int k, int start, List<Integer> tmp) {
        if (n < 0 || k < 0) {
            return;
        } else if (n == 0 && k == 0) {   // the correct path
            List<Integer> oneComb = new LinkedList<Integer>(tmp);
            result.add(oneComb);
        } else {  // dfs on the rest elements
            for (int i = start; i <=9; i++) {
                // add the element, dfs, and remove the element after recursion
                tmp.add(i);
                // i+1 in recursion to avoid duplication
                dfs(n-i, k-1, i+1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main (String[] args) {
        LC216CombinationSumIII l = new LC216CombinationSumIII();
        List<List<Integer>> result = l.combinationSum(3, 7);
        for (List<Integer> ll : result) {
            for (int i : ll) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
