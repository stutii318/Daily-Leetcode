import java.util.Stack;
class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < nums.length(); i++) {
            char digit = nums.charAt(i); // Current digit
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop(); // Remove the last digit
                k--; // Decrement k by 1
            }
            st.push(digit);
        }
        while (k > 0) {
            st.pop(); // Pop the last added digits
            k--; // Decrement k by 1
        }
        if (st.isEmpty()) return "0";
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }
        res.reverse();
        if (res.length() == 0) return "0";
        return res.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        String nums = "541892"; // Input number as string
        int k = 2; 
        Solution sol = new Solution();
        String ans = sol.removeKdigits(nums, k);
        System.out.println("The smallest possible integer after removing k digits is: " + ans);
    }
}