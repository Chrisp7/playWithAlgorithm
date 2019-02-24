package liked;

public class Lc273 {
    String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        int count = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + thousands[count] + " " + res;
            }
            num = num / 1000;
            count++;

        }
        return res.trim();
    }

    public String helper(int num) {
        if (num == 0) return "";
        if (num < 20) return less20[num] + " ";
        else if (num < 100) return tens[num / 10] + " " + helper(num % 10);
        else return less20[num / 100] + " Hundred " + helper(num % 100);
    }
}
