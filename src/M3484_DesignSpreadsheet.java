/**
 * 
 * M3484 Design Spreadsheet
 * https://leetcode.com/problems/design-spreadsheet/submissions/1791803807/?envType=daily-question&envId=2025-10-05
 */

import java.util.HashMap;

public class M3484_DesignSpreadsheet {

    class Spreadsheet {

        private HashMap<Character, int[]> columnMapping;

        public Spreadsheet(int rows) {

            columnMapping = new HashMap<>();
            char currChar = 'A';
            while(currChar != 'Z'+1){

                columnMapping.put(currChar, new int[rows]);
                currChar++;
            }
            
        }

        public void setCell(String cell, int value) {

            char col = cell.charAt(0);
            int row = Integer.parseInt(cell.substring(1))-1;
            int[] colArr = columnMapping.get(col);
            colArr[row] = value;
        
        }

        public void resetCell(String cell) {
            setCell(cell, 0);
        }

        public int getValue(String formula) {
            
            String[] tokens = formula.substring(1).split("\\+", 2);

            return getValueLookupHelper(tokens[0]) + getValueLookupHelper(tokens[1]);
    
        }

        private int getValueLookupHelper(String token){

            if(Character.isDigit(token.charAt(0))) return Integer.parseInt(token);
            return columnMapping.get(token.charAt(0))[Integer.parseInt(token.substring(1))-1];
        }
    }

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
    
}
