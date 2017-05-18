package com.tfr.collections.queue.example;

import com.tfr.collections.queue.ArrayBoundedQueue;
import com.tfr.collections.queue.Queue;
import com.tfr.collections.stack.ArrayBoundedStack;
import com.tfr.collections.stack.Stack;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class Palindromes {

    public static boolean test(String candidate) {
        boolean stillPalindrome = true;

        char ch;
        char fromStack;
        char fromQueue;

        int length = candidate.length();

        Stack<Character> stack = new ArrayBoundedStack<>(length);
        Queue<Character> queue = new ArrayBoundedQueue<>(length);

        for(int i=0; i<length; i++) {
            ch = candidate.charAt(i);
            if(Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                stack.push(ch);
                queue.enqueue(ch);
            }
        }

        while(stillPalindrome && !stack.isEmpty()) {
            fromStack = stack.top();
            stack.pop();
            fromQueue = queue.dequeue();
            if(fromStack != fromQueue) {
                stillPalindrome = false;
            }
        }

        return stillPalindrome;
    }

}
