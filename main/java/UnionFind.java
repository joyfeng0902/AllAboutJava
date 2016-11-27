package main.java;

public class UnionFind {
    // union find set
    private int[] parent;
    private int[] rank;

    public UnionFind(int max) {
        parent = new int[max];
        rank = new int[max];

        for (int i = 0; i < max; i ++) {
            parent[i] = i;
        }
    }

    public int[] getParent() {
        return parent;
    }

    // find its parent
    public int find(int i) {
        int p = parent[i];
        if (i == p) {
            return i;
        }
        return parent[i] = find(p);         // find and also update parent[i]
    }

    public void union(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);

        if (root1 == root2) {
            return;
        }

        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root2] > rank[root1]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }

    void printArray(String name, int[] nums) {
        System.out.print(name + " ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    void print(){
        printArray("parent", parent);
        printArray("rank  ", rank);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);

        uf.union(0,3);
        System.out.println("union 0 3");
        uf.print();

        uf.union(2,3);
        System.out.println("union 2 3");
        uf.print();

        uf.find(3);
        System.out.println("union 3");
        uf.print();

        uf.find(1);
        System.out.println("union 1");
        uf.print();

        uf.find(4);
        System.out.println("find 4");
        uf.print();

        System.out.println("*****************");
        uf = new UnionFind(5);

        uf.union(1,2);
        System.out.println("union 1 2");
        uf.print();

        uf.union(1,2);
        System.out.println("union 1 2");
        uf.print();

        uf.union(3,4);
        System.out.println("union 3 4");
        uf.print();

        uf.union(1,0);
        System.out.println("union 1 0");
        uf.print();

        uf.union(1,3);
        System.out.println("union 1 3");
        uf.print();

        uf.find(4);
        System.out.println("find 4");
        uf.print();
    }
}
