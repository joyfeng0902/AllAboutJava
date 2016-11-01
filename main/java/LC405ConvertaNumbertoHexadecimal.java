public class LC405ConvertaNumbertoHexadecimal {
    final char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();
        while (num != 0) {   // should be !=0 not >0 considering negative numbers
            result.append(map[num & 0xf]);
            // The unsigned right shift operator ">>>" shifts a zero into the leftmost position
            num >>>= 4;
        }

        return result.reverse().toString();
    }
}
