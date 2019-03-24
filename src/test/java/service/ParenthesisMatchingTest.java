package service;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParenthesisMatchingTest {

    @Test
    public void emptyExpressionTest() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertTrue(obj.match(""));
    }

    @Test
    public void expression_with_no_braces_test() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertTrue(obj.match("a+b+c*d"));
    }

    @Test
    public void single_character_expr_test() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertFalse(obj.match("["));
    }

    @Test
    public void balance_parenthesis_test1() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertTrue(obj.match("{a+c-[d*e/(x+y)]}"));
    }

    @Test
    public void balance_parenthesis_test2() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertTrue(obj.match("(a+b)*(c+d)"));
    }

    @Test
    public void balance_parenthesis_test3() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertTrue(obj.match("(a+b)"));
    }

    @Test
    public void parenthesis_test_with_pair_input() {
        Map<Character, Character> parenthesisPair = new HashMap<Character, Character>();
        parenthesisPair.put('(', ')');
        parenthesisPair.put('{', '}');
        parenthesisPair.put('[', ']');
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertTrue(obj.match("(a+b)"));
    }

    @Test
    public void balance_parenthesis_test4() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertTrue(obj.match("[dklf(df(kl))d]{}"));
    }
    @Test
    public void balance_parenthesis_test5() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertTrue(obj.match("{[[[()]]]}"));
    }

    @Test
    public void unbalance_parenthesis_test1() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertFalse(obj.match("{df][d}"));
    }
    @Test
    public void unbalance_parenthesis_test2() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertFalse(obj.match("((a+b)*(d+f)"));
    }
    @Test
    public void unbalance_parenthesis_test3() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertFalse(obj.match(")a+b("));
    }
    @Test
    public void unbalance_parenthesis_test4() {
        ParenthesisMatching obj = new ParenthesisMatching();
        Assert.assertFalse(obj.match(")"));
    }
}
