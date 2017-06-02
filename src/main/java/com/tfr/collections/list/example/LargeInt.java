package com.tfr.collections.list.example;

import java.util.Iterator;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class LargeInt {

    protected LargeIntList numbers;

    protected static final boolean PLUS = true;
    protected static final boolean MINUS = false;

    protected boolean sign;

    public LargeInt() {
        numbers = new LargeIntList();
        sign = PLUS;
    }

    public LargeInt(String intString) {
        this();

        int firstDigitPosition;
        int lastDigitPosition;

        char digitChar;
        byte digitByte;

        firstDigitPosition = 0;
        if(intString.charAt(0) == '+') {
            firstDigitPosition = 1;
        } else if(intString.charAt(0) == '-') {
            firstDigitPosition = 1;
            sign = MINUS;
        }

        lastDigitPosition = intString.length() - 1;

        for(int count=firstDigitPosition; count<=lastDigitPosition; count++) {
            digitChar = intString.charAt(count);
            digitByte = (byte) Character.digit(digitChar, 10);
            numbers.addRear(digitByte);
        }
    }

    public void setNegative() {
        sign = MINUS;
    }

    @Override
    public String toString() {
        Byte element;
        StringBuilder sb = new StringBuilder();

        if(sign) {
            sb.append("+");
        } else {
            sb.append("-");
        }

        int count = numbers.getSize();
        Iterator<Byte> forward = numbers.forward();

        while(forward.hasNext()) {
            element = forward.next();
            sb.append(element);
            if((((count - 1) % 3) == 0) && count != 1) {
                sb.append(",");
            }
            count--;
        }

        return sb.toString();
    }

    public static LargeInt add(LargeInt first, LargeInt second) {
        LargeInt sum = new LargeInt();

        System.out.println(String.format("Adding: [%s] + [%s]", first, second));

        if(first.sign == second.sign) {
            System.out.println("Same signs");
            if(greaterList(first.numbers, second.numbers)) {
                sum.numbers = addLists(first.numbers, second.numbers);
            } else {
                sum.numbers = addLists(second.numbers, first.numbers);
            }
            sum.sign = first.sign;
        } else {
            System.out.println("Opposite signs");
            if(greaterList(first.numbers, second.numbers)) {
                sum.numbers = subtractLists(first.numbers, second.numbers);
                sum.sign = first.sign;
            } else {
                sum.numbers = subtractLists(second.numbers, first.numbers);
                sum.sign = second.sign;
            }
        }
        System.out.println(String.format("Result = [%s]", sum));
        return sum;
    }

    public static LargeInt subtract(LargeInt first, LargeInt second) {
        LargeInt difference;

        System.out.println(String.format("Subtracting: [%s] - [%s]", first, second));

        LargeInt negativeSecond = new LargeInt();
        negativeSecond.sign = !second.sign;
        Iterator<Byte> secondForward = second.numbers.forward();
        int length = second.numbers.getSize();
        for(int count=1; count<=length; count++) {
            negativeSecond.numbers.addRear(secondForward.next());
        }
        System.out.println(String.format("Converting [%s] to [%s]", second, negativeSecond));
        difference = add(first, negativeSecond);

        return difference;
    }

    protected static boolean greaterList(LargeIntList first, LargeIntList second) {
        boolean greater = false;

        if(first.getSize() > second.getSize()) {
            greater = true;
        } else if(first.getSize() < second.getSize()) {
            greater = false;
        } else {
            byte digitFirst;
            byte digitSecond;
            Iterator<Byte> firstForward = first.forward();
            Iterator<Byte> secondForward = second.forward();

            int length = first.getSize();
            boolean keepChecking = true;
            int count = 1;

            while(count <= length && keepChecking) {
                digitFirst = firstForward.next();
                digitSecond = secondForward.next();
                if(digitFirst > digitSecond) {
                    greater = true;
                    keepChecking = false;
                } else if(digitFirst < digitSecond) {
                    greater = false;
                    keepChecking = false;
                }
                count++;
            }
        }
        return greater;
    }

    protected static LargeIntList addLists(LargeIntList larger, LargeIntList smaller) {
        byte digit1;
        byte digit2;
        byte temp;
        byte carry = 0;

        int largerLength = larger.getSize();
        int smallerLength = smaller.getSize();
        int lengthDiff;

        LargeIntList result = new LargeIntList();

        Iterator<Byte> largerReverse = larger.reverse();
        Iterator<Byte> smallerReverse = smaller.reverse();

        for(int count=1; count <= smallerLength; count++) {
            digit1 = largerReverse.next();
            digit2 = smallerReverse.next();
            temp = (byte)(digit1 + digit2 + carry);
            carry = (byte)(temp /10);
            result.addFront((byte)(temp % 10));
        }

        lengthDiff = (largerLength - smallerLength);

        for(int count=1; count<=lengthDiff; count++) {
            digit1 = largerReverse.next();
            temp = (byte)(digit1 + carry);
            carry = (byte)(temp / 10);
            result.addFront((byte)(temp % 10));
        }
        if(carry != 0) {
            result.addFront((byte) carry);
        }

        return result;
    }

    protected static LargeIntList subtractLists(LargeIntList larger, LargeIntList smaller) {
        byte digit1;
        byte digit2;
        boolean borrow = false;

        int largerLength = larger.getSize();
        int smallerLength = smaller.getSize();
        int lengthDiff;

        LargeIntList result = new LargeIntList();

        Iterator<Byte> largerReverse = larger.reverse();
        Iterator<Byte> smallerReverse = smaller.reverse();

        for(int count=1; count<=smallerLength; count++) {
            digit1 = largerReverse.next();
            if(borrow) {
                if(digit1 != 0) {
                    digit1 = (byte)(digit1 - 1);
                    borrow = false;
                } else {
                    digit1 = 9;
                    borrow = true;
                }
            }

            digit2 = smallerReverse.next();

            if(digit2 <= digit1) {
                result.addFront((byte)(digit1 - digit2));
            } else {
                borrow = true;
                result.addFront((byte)(digit1 + 10 - digit2));
            }
        }

        lengthDiff = largerLength - smallerLength;

        for(int count=1; count<=lengthDiff; count++) {
            digit1 = largerReverse.next();
            if(borrow) {
                if(digit1 != 0) {
                    digit1 = (byte)(digit1 - 1);
                    borrow = false;
                } else {
                    digit1 = 9;
                    borrow = true;
                }
            }
            result.addFront(digit1);
        }

        //remove leading zeroes
        LargeIntList finalResult = new LargeIntList();
        Iterator<Byte> resultForward = result.forward();
        boolean copy = false;
        while(resultForward.hasNext()) {
            byte val = resultForward.next();
            if(val != 0) {
                copy = true;
            }
            if(copy) {
                finalResult.addRear(val);
            }
        }

        return finalResult;
    }
}
