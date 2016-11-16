package main.java;

import java.util.Stack;

public class GoogleLC224BasicCalculator {
    // iterative solution
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        int result = 0, sign = 1, number = 0;
        // Only 5 possible input we need to pay attention:
        // digit: it should be one digit from the current number
        // '+': number is over, we can add the previous number and start a new number
        // '-': same as above
        // '(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.
        // ')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis, second is the temporary result before this pair of parenthesis. We add them together.
        // Finally if there is only one number, from the above solution, we haven't add the number to the result, so we do a check see if the number is zero.
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (int)(c - '0');
            } else if (c == '+') {
                result += number * sign;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += number * sign;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if (number != 0) {
            result += number * sign;
        }

        return result;
    }

    public static void main (String[] args) {
        GoogleLC224BasicCalculator g = new GoogleLC224BasicCalculator();
        g.calculate("(4  +  9)");
    }
}
