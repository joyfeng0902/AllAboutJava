package main.java;

import java.util.HashMap;
import java.util.Map;

public class Excel {
    private static final int MAX_CELL_INDEX = 65000;
    private final Map<Integer, Map<Integer, String>> data = new HashMap<Integer, Map<Integer, String>>();

    public void setValue(int row, int column, String value) {
        if (checkRowColumnIndex(row, column)) {
            Map<Integer, String> columnMap = data.get(row);
//            if () {
//            }
        }
    }

    boolean checkRowColumnIndex(int row, int column) {
        return data.containsKey(row) && data.get(row).containsKey(column);
    }
}
