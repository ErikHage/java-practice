package com.tfr.collections.stack.inuse;

import com.tfr.collections.stack.ArrayBoundedStack;
import com.tfr.collections.stack.Stack;
import com.tfr.collections.stack.StackUnderflowException;

/**
 * Evaluate Postscript expressions
 *
 * Created by Erik on 4/28/2017.
 */
public class PostfixEvaluator {

    private final String operators;

    public PostfixEvaluator() {
        this.operators = "+-x/";
    }

    public int evaluate(String expression) {
        System.out.println("Evaluating expression: " + expression);
        int result;
        Stack<String> stack = new ArrayBoundedStack<>(50);
        String[] items = expression.split(" ");

        int currentIndex = 0;
        String currentItem;

        while(currentIndex < items.length) {
            currentItem = items[currentIndex];
            if(!operators.contains(currentItem)) {
                stack.push(currentItem);
            } else {
                try {
                    int num2 = Integer.parseInt(stack.pop());
                    int num1 = Integer.parseInt(stack.pop());
                    int intermediateResult = performOperation(num1, num2, currentItem);
                    stack.push(String.valueOf(intermediateResult));
                } catch(StackUnderflowException ex) {
                    throw new IllegalArgumentException("Invalid expression: not enough operands");
                }
            }
            currentIndex++;
        }

        result = Integer.parseInt(stack.pop());
        if(!stack.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression: too many operands");
        }
        return result;
    }

    private int performOperation(int num1, int num2, String operation) {
        int result;
        System.out.println(String.format("Operation: %s %s %s", num1, num2, operation));
        switch(operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("");
        }
        return result;
    }

}
