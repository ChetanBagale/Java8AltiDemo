package demo.immutable;

import java.util.Stack;

public class DemoStack {

	public static String isBalanced(String s) {
		// Write your code her

		char leftCurly = '{', rightCurly = '}';
		char leftSquare = '[', rightSquare = ']';
		char leftRound = '(', rightRound = ')';

		Stack<Character> stack = new Stack();

		stack.push(s.charAt(0));
		System.out.println(s);

		int i = 1;
		for (; i < s.length(); i++) {
			char ch2 = ' ';
			char ch1 = s.charAt(i);
			if (!stack.empty())
				ch2 = stack.peek();
			if (ch1 == leftCurly || ch1 == leftRound || ch1 == leftSquare) {
				stack.push(ch1);

			} else {
				if (ch1 == rightCurly) {

					if (ch2 == leftCurly) {
						if (!stack.empty())
							stack.pop();
					} else
						stack.push(ch1);
				} else if (ch1 == rightRound) {
					if (ch2 == leftRound) {
						if (!stack.empty())
							stack.pop();
					} else
						stack.push(ch1);

				} else if (ch1 == rightSquare) {
					if (ch2 == leftSquare) {
						if (!stack.empty())
							stack.pop();
					} else
						stack.push(ch1);

				}
			}
		}

		String ans = "";

		if (i != s.length()) {

		}

		if (stack.empty() && i == s.length())
			ans = "YES";
		else
			ans = "NO";
		return ans;

	}

	public static void main(String[] args) {
		/*
		 * {(([])[])[]} {(([])[])[]]} {(([])[])[]}[]
		 */
		System.out.println(isBalanced("{}"));

		// TODO Auto-generated method stub

	}

}
