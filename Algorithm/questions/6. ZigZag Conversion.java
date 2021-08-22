class Solution {
    // "AB" 1
    // "ABC"  6
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        // "AB" 1
        if (numRows == 1) return s;
         
        StringBuilder[] sb = new StringBuilder[numRows];
        
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        
        boolean goingDown = true;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            sb[curRow].append(c); // if numRows == 1, this will fail, like  s = "AB", numRows = 1
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? -1 : 1;
        }
       
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) { // "ABC"  6
            ans.append(sb[i].toString());
        }
        return ans.toString();
    }
}