class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            s.append(digit);
            sum -= digit;
        }

        return sum == 0 ? s.toString() : "";  
    }
}