package Model.Expressions;

import Exceptions.ExpressionException;
import Utils.Interfaces.MyIDictionary;

public class ArithExp extends Exp {
	Exp right, left;
	char sign;
	
	public ArithExp(Exp left, Exp right, char sign) {
		this.left = left;
		this.right = right;
		this.sign = sign;
	}
	
	public ArithExp(char sign, Exp left, Exp right) {
		this.left = left;
		this.right = right;
		this.sign = sign;
	}
	
	public String toString() {
		return left.toString() + " " + sign + " " + right.toString();
	}
	
	public int eval(MyIDictionary<String, Integer> dict) throws ExpressionException {
		int left;
		int right;
		left = this.left.eval(dict);
		right = this.right.eval(dict);
		
		int result = 0;
		
		switch (sign) {
			case '+':
				result = left + right;
				break;
			case '-':
				result = left - right;
				break;
			case '*':
				result = left * right;
				break;
			case '/':
				if (right == 0)
					throw new ExpressionException("Division by zero");
				result = left / right;
				break;
		}
		return result;
	}
	
}
