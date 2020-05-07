package net.bossones.calc.pNote;

import net.bossones.calc.lilist.EmptyListException;
import net.bossones.calc.lilist.LinkedList;
import net.bossones.calc.stack.Stack;

import java.util.Objects;

/**
 * Utility for creating polish notation
 */
public class PolishNotation {

    /**
     * Fabric method for creating polish notation
     * @param expression for calculating
     * @return string of polish notation
     */
    public static LinkedList<String> makeNote(String expression) {
        Objects.requireNonNull(expression);
        LinkedList<String> polishNote = new LinkedList<>();
        Stack<Character> operators = new Stack<>();
        StringBuilder digit = new StringBuilder();
        boolean openingBracket = false;

        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '(':
                    openingBracket = true;
                    loadDigitToNote(digit, polishNote);
                    operators.add(expression.charAt(i));
                    break;
                case '*':
                case '/':
                    openingBracket = false;
                    loadDigitToNote(digit, polishNote);
                    operators.add(expression.charAt(i));
                    break;
                case '+':
                    openingBracket = false;
                    loadDigitToNote(digit, polishNote);
                    clearUntilEnd(polishNote, operators);
                    operators.add(expression.charAt(i));
                    break;
                case '-':
                    loadDigitToNote(digit, polishNote);
                    if (polishNote.size() == 0 || openingBracket) {
                        polishNote.addLast("0");
                    }
                    openingBracket = false;
                    clearUntilEnd(polishNote, operators);
                    operators.add(expression.charAt(i));
                    break;
                case ')':
                    openingBracket = false;
                    loadDigitToNote(digit, polishNote);
                    clearUntilOpenBracket(polishNote, operators);
                    break;
                case '\n':
                    openingBracket = false;
                    loadDigitToNote(digit, polishNote);
                    while (!operators.isEmpty())
                        polishNote.addLast(operators.remove().toString());
                    polishNote.addLast("\n");
                    break;
                case '\r':
                case ' ':
                    break;
                default:
                    openingBracket = false;
                    if (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.') {
                            digit.append(expression.charAt(i));
                    } else throw new IllegalArgumentException();
            }
        }
        loadDigitToNote(digit, polishNote);
        clearUntilEnd(polishNote, operators);
        return polishNote;
    }

    /**
     * Load all operators until opening bracket to polish notation linked list.
     * @param polishNote is a linked list needs to load operators
     * @param operators - operators of expression
     */
    private static void clearUntilOpenBracket(LinkedList<String> polishNote, Stack<Character> operators) {
        while (!operators.isEmpty() && operators.peek() != '(') {
            polishNote.addLast(operators.remove().toString());
        }
        try {
            operators.remove();
        } catch (EmptyListException e) {
            System.err.println("The expression needs an opening bracket!");
            System.err.println("Please, check your expression and print it again!");
            System.exit(-1);
        }
    }

    /**
     * Load all operators until end to polish notation linked list.
     * @param polishNote is a linked list needs to load operators.
     * @param operators of expression
     */
    private static void clearUntilEnd(LinkedList<String> polishNote, Stack<Character> operators) {
        while (!operators.isEmpty() && operators.peek() != '(') {
            polishNote.addLast(operators.remove().toString());
        }
    }

    /**
     * Load next digit to polish notation linked list.
     * @param digit for loading to polish notation
     * @param polishNote is a linked list
     */
    private static void loadDigitToNote(StringBuilder digit, LinkedList<String> polishNote) {
        if (digit.length() > 0) {
            polishNote.addLast(digit.toString());
            digit.delete(0, digit.length());
        }
    }
}
