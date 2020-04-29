package net.bossones.calc;

import net.bossones.calc.lilist.LinkedList;
import net.bossones.calc.pNote.PolishNotation;

import java.util.ListIterator;
import java.util.Objects;

public class Calculator {

    public static double calculate(String expression) {
        expression = Objects.requireNonNullElse(expression, "0.0");
        LinkedList<String> polishNote = PolishNotation.makeNote(expression);
        ListIterator<String> iterPolishNote = polishNote.iterator();
        while (polishNote.size() != 1 && !polishNote.isEmpty()) {
            if (iterPolishNote.hasNext()) {
                switch (iterPolishNote.next()) {
                    case "+" -> calculateIfOperator(iterPolishNote, "+");
                    case "-" -> calculateIfOperator(iterPolishNote, "-");
                    case "*" -> calculateIfOperator(iterPolishNote, "*");
                    case "/" -> calculateIfOperator(iterPolishNote, "/");
                }
            }
        }
        return Double.parseDouble(polishNote.removeLast());
    }

    private static void calculateIfOperator(ListIterator<String> iterPolishNote, String operator) {
        iterPolishNote.previous();
        double second = Double.parseDouble(iterPolishNote.previous());
        double first = Double.parseDouble(iterPolishNote.previous());
        iterPolishNote.next();
        switch (operator) {
            case "+" -> iterPolishNote.set(String.valueOf(second + first));
            case "-" -> iterPolishNote.set(String.valueOf(first - second));
            case "*" -> iterPolishNote.set(String.valueOf(second * first));
            case "/" -> iterPolishNote.set(String.valueOf(first / second));
        }
        for (int i = 0; i < 2; i++) {
            iterPolishNote.next();
            iterPolishNote.remove();
        }
        while (iterPolishNote.hasPrevious())
            iterPolishNote.previous();
    }
}
