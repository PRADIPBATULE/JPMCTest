package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/*
Class use is to check whether given expression has balanced and ordered parenthesis.
 */
public class ParenthesisMatching {

    private Map<Character, Character> parenthesisPair;

    public ParenthesisMatching() {
        parenthesisPair = new HashMap<Character, Character>();
        parenthesisPair.put(')', '(');
        parenthesisPair.put('}', '{');
        parenthesisPair.put(']', '[');
    }

    /*
    optional setter to facilitate the input of parenthesis pairs. key is open parenthesis and value is its close parenthesis match.
     */
    public void setParenthesisPair(Map<Character, Character> parenthesisPair) {
        if (parenthesisPair != null) {
            Map<Character, Character> mapInversed =
                    parenthesisPair.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        }
    }

    /*
    this method checks whether given expression has balanced and ordered parenthesis.
     */
    public Boolean match(String expression) {
        Stack<Character> stack = new Stack<Character>();
        char[] exprCharacters = expression.toCharArray();
        Boolean balanced = true;
        for (Character c : exprCharacters) {
            if (isClosingBrace(c)) {
                Character matchWithParenthesis = parenthesisPair.get(c);
                if (!findMatchingOpenParenthesis(stack, matchWithParenthesis)) {
                    balanced = false;
                    break;
                } else {
                    balanced = true;
                }
            } else {
                stack.push(c);
            }
        }
        if (doesStackContainOpenParenthesis(stack)) {
            balanced = false;
        }

        return balanced;
    }

    /*
    check whether stack has open parenthesis as one of its element.
     */
    private boolean doesStackContainOpenParenthesis(Stack<Character> stack) {
        boolean openParenthesisFound = false;
        while (!stack.isEmpty()) {
            if (parenthesisPair.values().contains(stack.pop())) {
                openParenthesisFound = true;
                break;
            }
        }
        return openParenthesisFound;
    }

    /*
       check whether given parenthesis has the matchParenthesis in it.
     */
    private Boolean findMatchingOpenParenthesis(Stack<Character> stack, Character matchWithParenthesis) {
        Boolean balanced = false;
        while (!stack.empty()) {
            Character popChar = stack.pop();
            if (matchWithParenthesis.equals(popChar)) {
                balanced = true;
                break;
            } else if (parenthesisPair.values().contains(popChar)) {
                balanced = false;
                break;
            }
        }
        return balanced;
    }

    private boolean isClosingBrace(Character c) {
        return parenthesisPair.keySet().contains(c);
    }

}
