import java.util.*;

class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        int n = nums.length();

        // iterate through all characters
        for (int i = 0; i < n; i++) {
            while (!st.empty() && k > 0 && (st.peek() - '0') > (nums.charAt(i) - '0')) {
                st.pop();
                k--;
            }
            st.push(nums.charAt(i));
        }

        // remove remaining k digits
        while (k > 0 && !st.empty()) {
            st.pop();
            k--;
        }

        // build result string
        StringBuilder res = new StringBuilder();
        while (!st.empty()) {
            res.append(st.pop());
        }

        // reverse since we popped from stack
        res.reverse();

        // remove leading zeros
        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        // handle empty string case
        if (res.length() == 0) return "0";
        return res.toString();
    }
}
