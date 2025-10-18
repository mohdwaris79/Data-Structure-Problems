public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        // Create rows
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[row].append(c);

            // change direction at top or bottom
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }

            row += goingDown ? 1 : -1;
        }

        // Merge rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }

    
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int numRows = 3;

        String output = convert(input, numRows);
        System.out.println("Original: " + input);
        System.out.println("ZigZag with " + numRows + " rows: " + output);
    }
}
