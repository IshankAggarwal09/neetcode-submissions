class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int remainder = columnNumber % 26;
            char ch = (char) (remainder + 'A');
            res.append(ch);
            columnNumber = columnNumber / 26;
        }
        return res.reverse().toString();
    }
}