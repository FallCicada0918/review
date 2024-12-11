/*
 * @Description: 
 * @Author: FallCicada
 * @Date: 2024-12-05 20:05:50
 * @LastEditors: FallCicada
 * @LastEditTime: 2024-12-05 20:20:41
 * @Slogan: 無限進步
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
    
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            reversed = reversed * 10 + pop;
        }
        return reversed;
    }

    
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        // Remove Whitespaces
        while (index < s.length() && s.charAt(index) == ' ') index++;
        // Handle signs
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        // Convert number and avoid overflow
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;
            // Check for overflow
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }
        return total * sign;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
            dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else if (p.charAt(j - 1) == '*') {
                dp[i][j] = dp[i][j - 2];
                if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            }
            }
        }

        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        
    }
}