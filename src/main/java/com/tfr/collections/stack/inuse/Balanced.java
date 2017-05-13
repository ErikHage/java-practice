package com.tfr.collections.stack.inuse;

import com.tfr.collections.stack.ArrayBoundedStack;
import com.tfr.collections.stack.Stack;
import com.tfr.collections.stack.StackUnderflowException;

/**
 * Evaluates if an expression has a balanced structured of open and close characters
 * (like {}, [], (), etc.)
 *
 * test results: 0 - balanced, 1 - unbalanced symbols, 2 - premature end of expression
 *
 * Created by Erik on 4/28/2017.
 */
public class Balanced {

    private String openSet;
    private String closeSet;

    public Balanced(String openSet, String closeSet) {
        this.openSet = openSet;
        this.closeSet = closeSet;
    }

    public int test(String expression) {
        System.out.println("Testing: " + expression);
        char currentChar;
        int currentCharIndex = 0;
        int lastCharIndex = expression.length() - 1;

        int openIndex;
        int closeIndex;

        boolean isStillBalanced = true;
        int result = 0;

        Stack<Integer> stack = new ArrayBoundedStack<>(expression.length());

        while(isStillBalanced && (currentCharIndex <= lastCharIndex)) {
            currentChar = expression.charAt(currentCharIndex);
            openIndex = openSet.indexOf(currentChar);

            if(openIndex != -1) {
                stack.push(openIndex);
            } else {
                closeIndex = closeSet.indexOf(currentChar);
                if(closeIndex != -1) {
                    try {
                        openIndex = stack.pop();
                        if(openIndex != closeIndex) {
                            isStillBalanced = false;
                        }
                    } catch(StackUnderflowException ex) {
                        isStillBalanced = false;
                    }
                }
            }

            currentCharIndex++;
        }

        if(!isStillBalanced) {
            result = 1;
        } else if(!stack.isEmpty()) {
            result = 2;
        }
        System.out.println("Result: " + result);
        return result;
    }

}
