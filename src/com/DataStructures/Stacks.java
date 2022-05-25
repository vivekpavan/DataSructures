package com.DataStructures;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Stacks {
    private final List<Character> leftBracket = Arrays.asList('{','[','(','<');
    private final List<Character> rightBracket = Arrays.asList('}',']',')','>');

    public String ReversingAString(String str) {
        if (str == null)
            throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        StringBuffer reversed = new StringBuffer();
        while (!stack.isEmpty())
            reversed.append(stack.pop());
        return reversed.toString();
    }

    public Boolean isBalancedExpression(String str) {

        Stack<Character> stack = new Stack<>();
        char character;
        for (var ch : str.toCharArray()) {
            if (isLeft(ch))
                stack.push(ch);

            if (isRight(ch)){
                if (stack.isEmpty()) return false;

                character = stack.pop();
                if (validate(character, ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    private  boolean isLeft(char ch){
        return (leftBracket.contains(ch));
    }
    private boolean isRight(char ch){
        return (rightBracket.contains(ch));
    }
    private boolean validate(char character, char ch) {
        return  (leftBracket.indexOf(character) != rightBracket.indexOf(ch));
//        return character == '(' && ch != ')' || character == '[' && ch != ']' || character == '{' && ch != '}' || character == '<' && ch != '>';
    }
}

